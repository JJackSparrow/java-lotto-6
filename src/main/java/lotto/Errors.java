package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Errors {
    static Lotto lotto;
    static Bonus bonus;

    public Errors() {
        this.lotto = lotto;
        this.bonus = bonus;
        this.bonus = bonus;
    }

    public void checkErrorsOfInputLottoNumbers(List<Integer> numbers) {
        int minInRange = 1;
        int maxInRange = 45;
        int drawCount = 6;

        String inputNumbers = Console.readLine();
        String[] temporaryInputNumbers = inputNumbers.split("[,\\s]+");

        for (String temporaryInputNumber : temporaryInputNumbers) {
            int userInputLottoNumbers = Integer.parseInt(temporaryInputNumber);
            numbers.add(userInputLottoNumbers);
        }

        // 6개의 수를 입력하지 않은 경우
        if (numbers.size() != drawCount) {
            throw new IllegalArgumentException("[Error] 로또 번호는 6개의 숫자로 입력해야 합니다.");
        }

        // 중복된 숫자가 있는 경우
        Set<Integer> hasDuplicateNumbers = new HashSet<>();
        for (int duplicateNumber : numbers) {
            if (!hasDuplicateNumbers.add(duplicateNumber)) {
                throw new IllegalArgumentException("[Error] 로또 번호에 중복된 숫자가 있습니다.");
            }
        }

        // 1 ~ 45 범위 벗어난 경우
        for (int i = 0; i < drawCount; i++) {
            if (maxInRange < lotto.getNumbers().get(i) || lotto.getNumbers().get(i) < minInRange) {
                throw new IllegalArgumentException("[Error] 로또 번호는 1부터 45까지의 범위 내 숫자로 입력해야 합니다.");
            }
        }

    }

    public static void checkErrorsOfInputMoney() {
        Money money = new Money();

        // 1000원 단위로 입력하지 않은 경우
        if(money.userInputCostOfLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력 가능합니다.");
        }

        // 1000원 미만의 값을 입력한 경우
        if(money.userInputCostOfLotto < 1000) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상만 입력 가능합니다.");
        }
    }

    public static void checkErrorsOfInputBonusNumber(List<Integer> bonusNumber) {
        String inputBonusNumber = Console.readLine();
        int userInputBonusNumber = Integer.parseInt(inputBonusNumber);
        bonusNumber.add(userInputBonusNumber);

        // 1개의 수를 입력하지 않은 경우
        if (bonusNumber.size() != bonus.bonusNumberSize) {
            throw new IllegalArgumentException();
        }

        // 1 ~ 45 범위 내 숫자 입력하지 않은 경우
        for (int numbersInRange : bonusNumber) {
            if (numbersInRange > bonus.maxInRange || numbersInRange < bonus.minInRange) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 범위 내 숫자로 입력해야 합니다.");
            }
        }

        // 중복된 숫자가 있는 경우
        Set<Integer> checkDuplicateNumbers = new HashSet<>(bonusNumber);
        checkDuplicateNumbers.addAll(bonus.getBonusNumber());

        if (checkDuplicateNumbers.size() != (bonus.bonusNumberSize + bonus.LottoNumberSize)) {
            throw new IllegalArgumentException("[ERROR] 로또번호와 중복되지 않는 수를 입력해야 합니다.");
        }
    }

}