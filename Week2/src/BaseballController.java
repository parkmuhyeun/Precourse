package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private static final int CONTINUE = 1;
    private static final int END = 2;
    private static final char NEW_LINE = '\n';
    private static final int SELECT_LENGTH = 1;

    private final OutputView outputView;
    private int system = CONTINUE;

    public BaseballController() {
        outputView = new OutputView();
    }

    public void run() {
        outputView.outputStartMessage();
        while (isContinue(system)) {
            Computer computer = new Computer();
            User user = new User();

            playGame(computer, user);
            outputView.outputEndMessage();
            outputView.outputAdditionalGame();
            String select = inputSelect();
            validateSelect(select);
            system = Integer.parseInt(select);
        }
    }

    private static void validateSelect(String select) {
        if (select.length() != 1 || !Character.isDigit(getCharacter(select)) || !isRightSelect(select))
            throw new IllegalArgumentException("1이나 2만 입력 가능합니다.");
    }

    private static boolean isRightSelect(String select) {
        int digit = Integer.parseInt(select);
        return digit == CONTINUE || digit == END;
    }

    private static char getCharacter(String select) {
        return select.charAt(0);
    }

    private String inputSelect() {
        return Console.readLine();
    }

    private static void playGame(Computer computer, User user) {
        int game = CONTINUE;
        while (isContinue(game)) {
            System.out.print("숫자를 입력해주세요 : ");
            Ball ball = computer.compareDigits(user.input());
            System.out.println(ball.toString());
            game = isEnd(ball);
        }
    }

    private static boolean isContinue(int game) {
        return game == CONTINUE;
    }

    private static int isEnd(Ball ball) {
        if (ball.isEnd())
            return END;
        return CONTINUE;
    }
}
