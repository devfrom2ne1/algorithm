import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    boolean[] visited;

    public int solution(String[] user_id, String[] banned_id) {
        // 각 banned_id에 대응하는 user_id 후보군 리스트 만들기
        List<List<String>> candidates = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.')) // 정규식 변환
                .map(pattern -> Arrays.stream(user_id)
                        .filter(id -> id.matches(pattern))
                        .toList()) // 리스트로 수집
                .toList();

        // 백트래킹 시작
        dfs(candidates, new HashSet<>(), 0);
        return result.size();
    }

    private void dfs(List<List<String>> candidates, Set<String> path, int depth) {
        if (depth == candidates.size()) {
            result.add(new HashSet<>(path));
            return;
        }

        for (String id : candidates.get(depth)) {
            if (!path.contains(id)) {
                path.add(id);
                dfs(candidates, path, depth + 1);
                path.remove(id); // 백트래킹
            }
        }
    }
}
