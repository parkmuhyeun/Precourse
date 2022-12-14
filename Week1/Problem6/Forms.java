package problem6;

import java.util.*;
import java.util.stream.Collectors;

public class Forms {

    private List<List<String>> forms;

    public Forms(List<List<String>> forms) {
        this.forms = forms;
    }

    public List<String> getProblematicEmails() {
        List<String> emails = new ArrayList<>();
        Map<String, Integer> count = saveConsecutiveCharacter();
        for (int i = 0; i < forms.size(); i++) {
            checkConsecutiveCharacter(new CheckDto(emails, count, i));
        }

        return getProcessedEmails(emails);
    }

    private List<String> getProcessedEmails(List<String> emails) {
        return emails
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private void checkConsecutiveCharacter(CheckDto checkDto) {
        boolean stop = false;
        for (int j = 0; j < getNickname(checkDto.getIndex()).length(); j++) {
            stop = canCheck(checkDto, stop, j);
        }
    }

    private boolean canCheck(CheckDto checkDto, boolean stop, int index) {
        if (!stop) {
            stop = check(checkDto, stop, index);
        }
        return stop;
    }

    private boolean check(CheckDto checkDto, boolean stop, int start) {
        String nickname = getNickname(checkDto.getIndex());
        for (int k = start + 1; k < nickname.length(); k++) {
            KeyDto keyDto = new KeyDto(nickname, start, k);
            stop = canDuplication(checkDto, stop, keyDto);
        }
        return stop;
    }

    private boolean canDuplication(CheckDto checkDto, boolean stop, KeyDto keyDto) {
        if (isDuplication(checkDto, stop, keyDto)) {
            checkDto.getEmails().add(getEmail(checkDto.getIndex()));
            stop = true;
        }
        return stop;
    }

    private boolean isDuplication(CheckDto checkDto, boolean stop, KeyDto keyDto) {
        return !stop && checkDto.getCount().get(getKey(keyDto)) >= 2;
    }

    private String getEmail(int index) {
        return forms.get(index).get(0);
    }

    private Map<String, Integer> saveConsecutiveCharacter() {
        HashMap<String, Integer> count = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String nickname = getNickname(i);
            countConsecutiveCharacter(count, nickname);
        }

        return count;
    }

    private void countConsecutiveCharacter(HashMap<String, Integer> count, String nickname) {
        for (int j = 0; j < nickname.length() - 1; j++) {
            count(count, nickname, j);
        }
    }

    private void count(HashMap<String, Integer> count, String nickname, int start) {
        for (int k = start + 1; k < nickname.length(); k++) {
            addCount(count, getKey(new KeyDto(nickname, start, k)));
        }
    }

    private void addCount(HashMap<String, Integer> count, String key) {
        count.put(key, count.getOrDefault(key, 0) + 1);
    }

    private String getKey(KeyDto keyDto) {
        return keyDto.getNickname().substring(keyDto.getStart(), keyDto.getEnd() + 1);
    }

    private String getNickname(int index) {
        return forms.get(index).get(1);
    }
}
