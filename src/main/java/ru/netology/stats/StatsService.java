package ru.netology.stats;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StatsService {

// Номер месяца, в котором был минимум продаж, то есть осуществлены продажи на минимальную сумму.

    public int minSales(long[] sales) {
        int minMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[minMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return minMonth + 1;
    }

// Номер месяца, в котором был пик продаж, то есть осуществлены продажи на максимальную сумму.

    public int maxSales(long[] sales) {
        int maxMonth = 0;
        int month = 0; // переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            // sales[maxMonth] - продажи в месяце minMonth
            // sale - продажи в рассматриваемом месяце
            if (sale >= sales[maxMonth]) {
                maxMonth = month;
            }
            month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

// Сумма всех продаж.

    public long sumSales(long[] sales) {
        long sumSales = 0;
        for (long sale : sales) {
            sumSales += sale;
        }
        return sumSales;
    }

// Средняя сумма продаж в месяц.

    public long averageSumSales(long[] sales) {

        return sumSales(sales) / sales.length;

    }

// Количество месяцев, в которых продажи были ниже среднего (см. п.2).

    public long lowAverageSumSales(long[] sales) {
        long maxSales = averageSumSales(sales);
        int monthAmount = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] < maxSales) {
                monthAmount++;
            }
        }
        return monthAmount;
    }

// Количество месяцев, в которых продажи были выше среднего.

    public long upAverageSumSales(long[] sales) {
        long maxSales = averageSumSales(sales);
        int monthAmount = 0;
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= maxSales) {
                monthAmount++;
            }
        }
        return monthAmount;
    }
}

