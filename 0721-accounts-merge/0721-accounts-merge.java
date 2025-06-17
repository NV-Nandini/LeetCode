class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Build the parent map and email-to-name map
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
                union(parent, account.get(1), email); // connect all emails in same account
            }
        }

        // Step 2: Group emails by root
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.putIfAbsent(root, new TreeSet<>());
            unions.get(root).add(email);
        }

        // Step 3: Format the result
        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(unions.get(root));
            result.add(merged);
        }

        return result;
    }

    private String find(Map<String, String> parent, String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent, parent.get(email)));
        }
        return parent.get(email);
    }

    private void union(Map<String, String> parent, String email1, String email2) {
        String root1 = find(parent, email1);
        String root2 = find(parent, email2);
        if (!root1.equals(root2)) {
            parent.put(root2, root1);
        }
    }
}
