import java.util.Stack;

class ArrRange
{
    // структура для хранения индексов границ массива
    public int low, high;
    public ArrRange(int from, int to)
    {
        this.low  = from;
        this.high = to;
    }
}

public class QuickSort
{
    // Задаем размер массива
    static int size = 0;

    // Объявляем массив
    int[] a;

    // Стек для хранения индексов начала и конца массива
    Stack<ArrRange> stack;

    QuickSort (int length)
    {
        size = length;
        a = new int[size];
        for (int i = 0; i < size; i++) a[i] = (int) (Math.random() * 100);
        stack = new Stack<ArrRange>();
        stack.push(new ArrRange(0, a.length - 1));
    }

    int step = -1;              // текущий шаг
    int temp1 = -1, temp2 = -1; // текущие переставляемые элементы
    int middle = -1;            // середина массива
    int prop;                  // опорный элемент
    int low, high;
    ArrRange range;


    public void NextStep()
    {
        switch (step) {
            case -1 -> {
                range = stack.pop();
                step = 0;
            }
            // находим опорный элемент
            case 0 -> {
                middle = (range.low + range.high) >> 1;
                prop = a[middle];
                low = range.low;
                high = range.high;
                step = 1;
            }
            // ишем слева элемент больше опорного
            case 1 -> {
                while (a[low] < prop) low++;
                temp1 = a[low];
                step = 2;
            }
            // ишем справа элемент меньше опорного
            case 2 -> {
                while (a[high] > prop) high--;
                temp2 = a[high];
                step = 3;
            }
            // меняем местами
            case 3 -> {
                if (low <= high) {
                    int temp = a[low];
                    a[low] = a[high];
                    a[high] = temp;
                    low++;
                    high--;
                }
                step = low <= high ? 1 : 4;
            }
            // разделить массив на 2 части
            case 4 -> {
                if (low < middle) {
				  /*
				    правая часть больше:
				    если в ней больше 1 элемента - нужно сортировать, отправляем в стек
				    следующая итерация разделения будет работать с левой частью
				  */
                    if (low < range.high) stack.push(new ArrRange(low, range.high));
                    range.high = high;
                } else {
				  /*
				    левая часть больше:
				    следующая итерация разделения будет работать с правой частью
				  */
                    if (high > range.low) stack.push(new ArrRange(range.low, high));
                    range.low = low;
                }
                step = (range.low < range.high) ? 0 : (stack.size() > 0) ? -1 : 5;
            }
        }
    }
}