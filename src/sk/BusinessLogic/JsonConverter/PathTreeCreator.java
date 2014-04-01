package sk.BusinessLogic.JsonConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.entities.FileVersionExtendedDto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.3.2014
 * Time: 17:07
 */


public class PathTreeCreator {
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	private JSONObject jsonObject;
	private List<String> changedFilesName = new LinkedList<>();
	private List<FileVersionExtendedDto> changedFiles = new LinkedList<>();

	public PathTreeCreator(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	private static final Pattern PATH_SEPARATOR = Pattern.compile("/");

	public static class Node {
		private final Map<String, Node> children = new TreeMap<>();

		public Node getChild(String name) {
			if (children.containsKey(name))
				return children.get(name);

			Node result = new Node();
			children.put(name, result);
			return result;
		}

		public Map<String, Node> getChildren() {
			return Collections.unmodifiableMap(children);
		}
	}

	private final Node root = new Node();


	public void addPath(String path) {
		String[] names = PATH_SEPARATOR.split(path);
		Node node = root;
		for (String name : names)
			node = node.getChild(name);
	}

	public void addChangedFilesName(String path) {
		String[] names = PATH_SEPARATOR.split(path);
		changedFilesName.add(names[names.length - 1]);
	}

	public void addChangedFiles(List<FileVersionExtendedDto> fileVersionDtoList) {
		this.changedFiles = fileVersionDtoList;
	}


	private void buildJsonTree(Node node, JSONArray jsonArray, Integer r, Integer g, Integer b) {
		Map<String, Node> children = node.getChildren();

		for (Map.Entry<String, Node> child : children.entrySet()) {
			Map map = new LinkedHashMap();
			map.put("name", child.getKey());
			map.put("size", 1);
			map.put("size", child.getValue().hashCode());
			if (changedFilesName.contains(child.getKey())) {
				int index = changedFilesName.indexOf(child.getKey());
				map.put("commiter", changedFiles.get(index).getCommiter().getId());

				if (changedFiles.get(index).getAncestor1ChangeType().getValue().value().equals("Add")) {
					map.put("color", "#1dd300");
				} else if (changedFiles.get(index).getAncestor1ChangeType().getValue().value().equals("Edit")) {
					map.put("color", "#ffa500");
				} else {
					map.put("color", "#cccccc");
				}
			} else {
				map.put("color", "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b));
			}

			jsonArray.add(map);

			JSONArray nextJsonArray = new JSONArray();

			if (!child.getValue().getChildren().isEmpty()) {
				buildJsonTree(child.getValue(), nextJsonArray, r + 19, g + 12, b + 5);
				map.put("children", nextJsonArray);
			}
		}
	}

	public void buildJsonTree() {
		int r = 66, g = 139, b = 202;
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("name", "PROJEKT");
		jsonObject.put("color", "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b));
		jsonObject.put("children", jsonArray);
		buildJsonTree(root, jsonArray, r + 19, g + 12, b + 5);
	}
}
