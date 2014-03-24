package sk.BusinessLogic.JsonConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.LinkedHashMap;
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


    public PathTreeCreator(JSONObject jsonObject){
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

    private void buildJsonTree(Node node, JSONArray jsonArray) {
        Map<String, Node> children = node.getChildren();

        for (Map.Entry<String, Node> child : children.entrySet()) {
            Map map = new LinkedHashMap();
            map.put("name", child.getKey());
            map.put("size",child.getValue().hashCode());
            jsonArray.add(map);

            JSONArray nextJsonArray = new JSONArray();

            if (!child.getValue().getChildren().isEmpty())
            {
                buildJsonTree(child.getValue(),nextJsonArray);
                map.put("children",nextJsonArray);
            }
        }
    }

    public void buildJsonTree() {
        JSONArray jsonArray = new JSONArray();
        jsonObject.put("name","PROJEKT");
        jsonObject.put("children",jsonArray);
        buildJsonTree(root,jsonArray);
    }
}
