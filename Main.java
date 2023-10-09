import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestXSequence {
    public static void main(String[] args) {
        String fileName = "input.txt"; // Имя файла для анализа

        try {
            // Открываем файл для чтения
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int maxSequenceLength = 0; // Максимальная длина последовательности 'X'
            int currentSequenceLength = 0; // Текущая длина текущей последовательности 'X'

            while ((line = reader.readLine()) != null) {
                // Читаем строку из файла
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    
                    if (c == 'X') {
                        // Если символ 'X' встречается, увеличиваем длину текущей последовательности 'X'
                        currentSequenceLength++;
                    } else {
                        // Если символ отличается от 'X', сравниваем текущую длину с максимальной
                        if (currentSequenceLength > maxSequenceLength) {
                            maxSequenceLength = currentSequenceLength;
                        }
                        currentSequenceLength = 0; // Сбрасываем текущую длину
                    }
                }
            }

            // Проверяем длину последовательности в конце файла
            if (currentSequenceLength > maxSequenceLength) {
                maxSequenceLength = currentSequenceLength;
            }

            // Закрываем файл
            reader.close();

            // Выводим результат
            System.out.println("Самая длинная последовательность 'X' состоит из " + maxSequenceLength + " символов.");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
