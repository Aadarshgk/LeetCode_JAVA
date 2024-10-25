import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    class Trie {
        boolean end;
        HashMap<String, Trie> subTrie;

        public Trie() {
            this.end = false;
            this.subTrie = new HashMap<>();
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();

        for (String file : folder) {
            Trie cur = root;
            String[] ar = file.split("/");

            for (String s : ar) {
                if (s.equals(""))
                    continue;
                if (cur.end)
                    break;

                if (!cur.subTrie.containsKey(s)) {
                    cur.subTrie.put(s, new Trie());
                }
                cur = cur.subTrie.get(s);
            }
            cur.end = true;
        }

        getString(root, "");
        return res;
    }

    public void getString(Trie node, String str) {
        if (node.end) {
            res.add(str);
            return;
        }

        for (String key : node.subTrie.keySet()) {
            getString(node.subTrie.get(key), str + "/" + key);
        }
        return;

    }
}