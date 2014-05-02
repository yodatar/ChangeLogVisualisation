package sk.BusinessLogic.JsonConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import sk.BusinessLogic.entities.FileVersionExtendedDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
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

	private JSONObject jsonObject = new JSONObject();
	private List<String> changedFilesName = new LinkedList<>();
	private List<FileVersionExtendedDto> changedFiles = new LinkedList<>();

	public PathTreeCreator() {
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

	public void addChangedFiles(List<FileVersionExtendedDto> fileVersionExtendedList) {

		for (FileVersionExtendedDto fileVersionExtendedDto : fileVersionExtendedList) {
			String[] names = PATH_SEPARATOR.split(fileVersionExtendedDto.getFileVersionDto().getUrl().getValue());
			List<String> pathList = new LinkedList<>();

			for (int i = 0; i < names.length; i++) {
				pathList.add(names[i]);
			}

			fileVersionExtendedDto.setPathNames(pathList);
			changedFilesName.add(names[names.length - 1]);
		}

		this.changedFiles = fileVersionExtendedList;
	}


	private void buildJsonTree(Node node, JSONArray jsonArray, Integer r, Integer g, Integer b) {
		Map<String, Node> children = node.getChildren();

		for (Map.Entry<String, Node> child : children.entrySet()) {
			Map map = new LinkedHashMap();
			map.put("name", child.getKey());
			map.put("size", 1);
			if (changedFilesName.contains(child.getKey())) {
				int index = changedFilesName.indexOf(child.getKey());

				Set<Integer> commitersSet = new HashSet();
				ListIterator it = changedFilesName.listIterator();
				while (it.hasNext()) {
					if (it.next().equals(child.getKey())) {
						commitersSet.add(changedFiles.get(it.previousIndex()).getCommiter().getId());
					}
				}

				JSONArray jsonArrayCommiters = new JSONArray();
				for (Integer commiterId : commitersSet) {
					Map commitersMap = new HashMap();
					commitersMap.put("id", commiterId);
					jsonArrayCommiters.add(commitersMap);
				}
				map.put("commiters", jsonArrayCommiters);


				if (changedFiles.get(index).getFileVersionDto().getAncestor1ChangeType().getValue().value().equals("Add")) {
					map.put("color", "#1dd300");
				} else if (changedFiles.get(index).getFileVersionDto().getAncestor1ChangeType().getValue().value().equals("Edit")) {
					map.put("color", "#ffa500");
				} else {
					map.put("color", "#aaaaaa");
				}
			} else {
				map.put("color", "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b));
			}

			jsonArray.add(map);

			JSONArray nextJsonArray = new JSONArray();

			if (!child.getValue().getChildren().isEmpty()) {
				if (r + 19 > 254) r = 230;
				buildJsonTree(child.getValue(), nextJsonArray, r + 19, g + 12, b + 5);
				map.put("children", nextJsonArray);
			}
		}
	}

	public void buildJsonTree() {
		int r = 47, g = 127, b = 197;
		JSONArray jsonArray = new JSONArray();
		jsonObject.put("name", "Project");
		jsonObject.put("color", "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b));
		jsonObject.put("children", jsonArray);
		buildJsonTree(root, jsonArray, r + 19, g + 12, b + 5);
	}
}
