package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);

        System.out.println("\n당첨번호를 입력해주세요.(쉼표(,)로 구분)");

        Errors errors = new Errors();
        errors.checkErrorsOfInputLottoNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validateOfLottoNumbers() {

        Errors errors = new Errors();

        boolean validInputLottoNumber = false;
        while (!validInputLottoNumber) {
            try {
                errors.checkErrorsOfInputLottoNumbers(numbers);
                validInputLottoNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("[Error] 숫자만 입력 가능합니다.");
                System.out.println("다시 입력해주세요.");
                numbers.clear();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
                numbers.clear();
            }

        }
        numbers = this.numbers;
        return this.numbers = getNumbers();
    }

}