class Solution {
    public int minMutation(String start, String end, String[] bank) {
        List<String> bankList = new ArrayList<>(Arrays.asList(bank));
        if (!bankList.contains(end)) {
            return -1;
        }
        bankList.add(start);

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        queue1.offer(start);
        queue2.offer(end);
        visited1.add(start);
        visited2.add(end);

        int count = 0;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() > queue2.size()) {
                Queue<String> q = queue1;
                queue1 = queue2;
                queue2 = q;

                Set<String> v = visited1;
                visited1 = visited2;
                visited2 = v;
            }
            count++;
            int size = queue1.size();
            while (size-- > 0){
                String queueStr = queue1.poll();
                for (String s : bankList) {
                    if (visited1.contains(s)) {
                        continue;
                    }
                    if (!canConverted(queueStr, s)) {
                        continue;
                    }
                    if (visited2.contains(s)) {
                        return count;
                    }
                    visited1.add(s);
                    queue1.offer(s);
                }
            }
        }
        return -1;

    }

    private boolean canConverted(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i))
                if (++count > 1) return false;
        }
        return count == 1;
    }
}
