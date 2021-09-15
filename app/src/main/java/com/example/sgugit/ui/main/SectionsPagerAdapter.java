package com.example.sgugit.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.sgugit.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    public static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5, R.string.tab_text_6, R.string.tab_text_7, R.string.tab_text_8, R.string.tab_text_9, R.string.tab_text_10,
            R.string.tab_text_11, R.string.tab_text_12, R.string.tab_text_13, R.string.tab_text_14, R.string.tab_text_15};

    public static final String[][] TAB_EXERCISES = new String[][]{
            // Бицепс
            new String[]{"Подъем гантели сидя с упором в бедро", "Подъем EZ-штанги на бицепс на скамье Скотта", "Подъем EZ-штанги на бицепс на скамье Скотта обратным хватом", "Подъем EZ-штанги на бицепс стоя", "Подъем EZ-штанги на бицепс стоя узким хватом", "Подъем гантелей на бицепс в наклоне",
                    "Подъем гантелей на бицепс на наклонной скамье хватом «молоток»", "Подъем гантелей на бицепс на скамье Скотта", "Подъем гантелей на бицепс пронированным хватом стоя", "Подъем гантелей на бицепс сидя", "Подъем гантелей на бицепс стоя", "Подъем гантелей на бицепс хватом «молоток»",
                    "Подъем гантелей на бицепс через стороны сидя", "Подъем гантелей на бицепс через стороны стоя", "Подъем штанги на бицепс", "Подъем штанги на бицепс на наклонной скамье", "Подъем штанги на бицепс обратным хватом", "Подъем штанги на бицепс узким хватом",
                    "Подъем штанги на бицепс узким хватом в положении сидя", "Подъем штанги на бицепс широким хватом", "Поочередное сгибание рук на бицепс сидя на наклонной скамье", "Попеременный подъем гантелей на бицепс", "Попеременный подъем гантелей на бицепс хватом «молоток»",
                    "Сгибание одной рукой на бицепс на скамье Скотта", "Сгибание рук на бицепс на блоке в положении лежа", "Сгибание рук на бицепс на верхнем блоке", "Сгибание рук на бицепс на верхнем блоке узким хватом", "Сгибание рук на бицепс на нижнем блоке обратным хватом",
                    "Сгибание рук на бицепс на нижнем блоке с канатной рукоятью", "Сгибание рук на бицепс на скамье Скотта на нижнем блоке", "Сгибание рук на бицепс над головой на верхнем блоке", "Сгибание рук на бицепс перед собой с гантелями хватом «молоток»", "Сгибание рук на бицепс с гантелями лежа",
                    "Сгибание рук на бицепс с диском", "Сгибание рук на бицепс с наклоном вперед", "Сгибание рук на бицепс со штангой в положении лежа", "Сгибание рук на бицепс со штангой с отведением локтей назад", "Сгибание рук на бицепс хватом «молоток» на скамье Скотта",
                    "Сгибание рук на бицепс-машине", "Сгибание рук с гантелями на бицепс на наклонной скамье", "Сгибание руки на бицепс на нижнем блоке стоя", "Сгибание руки на бицепс стоя рядом с наклонной скамьей", "Сгибания на бицепс в тренажере", "Сгибания рук на бицепс на нижнем блоке стоя"},
            // Грудь
            new String[]{"Жим в тренажере", "Жим в тренажере с отрицательным наклоном", "Жим в тренажере с положительным наклоном", "Жим гантелей лежа", "Жим гантелей лежа на полу", "Жим гантелей лежа на скамье с отрицательным наклоном", "Жим гантелей лежа на скамье с положительным наклоном",
                    "Жим гантелей лежа на скамье с положительным наклоном хватом молоток", "Жим лежа в машине Смита", "Жим лежа на наклонной скамье в машине Смита", "Жим лежа широким хватом", "Жим на верхнем блоке стоя", "Жим на шею лежа на горизонтальной скамье", "Жим плечами лежа на наклонной скамье",
                    "Жим Свенда", "Жим штанги лежа", "Жим штанги лежа на скамье с отрицательным наклоном", "Жим штанги лежа на скамье с положительным наклоном", "Кроссовер с эспандером", "Отведение гантелей через стороны лежа", "Отжимания", "Отжимания на брусьях", "Пуловер и подъем",
                    "Пуловер с гантелей лежа на скамье", "Пуловер со штангой на наклонной скамье", "Сведение гантелей лежа", "Сведение гантелей на скамье с отрицательным наклоном", "Сведение гантелей на скамье с положительным наклоном", "Сведение рук в кроссовере", "Сведение рук в тренажере (Бабочка)",
                    "Сведения рук на нижнем блоке лежа"},
            // Дельтовидные мышцы (Плечи)
            new String[]{"Армейский жим стоя", "Вертикальная тяга штанги", "Вращение плеча внутрь", "Жим гантелей от Арнольда Шварценеггера", "Жим гантелей плечами на наклонной скамье", "Жим гантелей сидя", "Жим гантелей стоя", "Жим гантели одной рукой", "Жим гири одной рукой",
                    "Жим гири от Арнольда Шварценеггера", "Жим гирь над собой", "Жим сидя в тренажере", "Жим штанги сидя", "Жим штанги сидя в машине Смита", "Жим штанги сидя широким хватом", "Жим штанги стоя из-за головы", "Изолированное разведение гантелей в стороны двумя руками",
                    "Комплексный жим гантелей", "Комплексный жим штанги сидя", "Кубинский жим", "Отведение руки в сторону в наклоне на блоке", "Отведение руки в сторону на нижнем блоке", "Подъём блина перед собой", "Подъем гантелей", "Подъём гантелей над головой", "Подъем гантелей перед собой",
                    "Подъём гантелей перед собой на наклонной скамье", "Подъём гантели одной рукой в сторону", "Подъём гирь на плечи", "Подъем штанги на грудь и жим", "Подъем штанги на плечи", "Подъём штанги плечами сидя в машине Смита", "Попеременная тяга гирь", "Попеременный жим гирь стоя",
                    "Разведение гантелей лежа на наклонной скамье лицом вниз", "Разведение гантелей сидя в наклоне", "Разведение рук в тренажере (обратная бабочка)", "Разведение рук с гантелями в стороны сидя", "Разведение рук с гантелями в стороны стоя", "Разведение рук с гантелями в упоре",
                    "Рывок гири одной рукой", "Рывок и толчок гири одной рукой", "Толчок гири одной рукой", "Толчок гирь над собой", "Толчок и жим штанги стоя", "Толчок и жим штанги стоя из-за спины", "Тяга к лицу", "Тяга к шее в гребном тренажере", "Тяга штанги к груди в наклоне"},
            // Задние мышцы бедра
            new String[]{"Взятие гири на грудь двумя руками", "Мощный рывок штанги над головой", "Обратная гиперэкстензия", "Подъем туловища в тренажере", "Подъем штанги на грудь", "Прыжки на подставку", "Прыжки с выпадами", "Румынская становая тяга", "Рывковая становая тяга",
                    "Рывок с выпадом", "Рывок штанги над головой", "Сгибание ног в тренажере лежа", "Сгибание ног в тренажере сидя", "Сгибание ног в тренажере стоя", "Становая тяга в машине Смита с прямыми ногами", "Становая тяга с гантелями", "Становая тяга со штангой с прямыми ногами"},
            // Икры
            new String[]{"Подъем на носки в тренажере сидя", "Подъем на носки в тренажере стоя", "Подъем на носки на одной ноге", "Подъем на носки с гантелей сидя", "Подъем на носки с гантелями стоя", "Подъем на носки со штангой", "Подъем на носки со штангой сидя", "Подъем на пятки в машине Смита",
                    "Подъем носков в тренажере для жима ногами", "Попеременный подъем на пятки и на носки со штангой"},
            // Квадрицепс
            new String[]{"Бег на беговой дорожке", "Боковые выпады со штангой", "Быстрые приседания со штангой", "Вертикальный жим ногами", "Взятие штанги на грудь с выпадом", "Выпады назад с гантелями (обратные выпады)", "Выпады с гантелями", "Выпады со штангой", "Выпрямление ног в тренажере",
                    "Гакк-приседания", "Глубокие приседания с гирями", "Глубокие приседания со штангой", "Глубокие приседания со штангой на груди", "Гребной тренажер", "Езда на велотренажере", "Жим ногами", "Жим ногами с узкой постановкой стоп", "Заход на скамью с гантелями", "Заход на скамью со штангой",
                    "Олимпийские приседания", "Приведения ноги на нижнем блоке", "Приседания Андерсона", "Приседания в машине Смита", "Приседания в машине Смита на одной ноге", "Приседания в силовой раме", "Приседания в тренажере в положении лежа", "Приседания Джефферсона", "Приседания Зерхера",
                    "Приседания с гантелями", "Приседания со штангой", "Приседания со штангой за спиной", "Приседания со штангой на груди", "Приседания со штангой на одной ноге", "Приседания со штангой над головой", "Рывок из-за головы", "Становая тяга", "Толчок с выпадом", "Толчок штанги от груди",
                    "Толчок штанги от груди с приседом"},
            // Поясница
            new String[]{"Гиперэкстензия", "Становая тяга в силовой раме с эспандерами", "Становая тяга на платформе или подставке", "Становая тяга со штангой", "Тяга в силовой раме", "Упражнение «доброе утро» в положении сидя", "Упражнение «Доброе утро» с прямыми ногами"},
            // Предплечье
            new String[]{"Подъем и удержание гири перед собой", "Сгибание запястий на нижнем блоке", "Сгибание запястий на нижнем блоке сидя на скамье", "Сгибание запястий на скамье с гантелями ладонями вверх", "Сгибание запястий на скамье с гантелями ладонями вниз",
                    "Сгибание запястий на скамье со штангой ладонями вверх", "Сгибание запястий на скамье со штангой ладонями вниз", "Сгибание запястий с пронацией в положении лежа", "Сгибание запястий с супинацией в положении лежа", "Сгибание запястий сидя на скамье с гантелями ладонями вверх",
                    "Сгибание запястий сидя на скамье с гантелями ладонями вниз", "Сгибание запястий со штангой сидя на скамье (ладонями вверх)", "Сгибание запястий со штангой сидя на скамье (ладонями вниз)", "Сгибание запястья сидя на скамье пронированным хватом",
                    "Сгибания запястий за спиной со штангой в положении стоя", "Удержание веса стоя"},
            // Пресс
            new String[]{"«Велосипед»", "«Восьмерки» с гирей", "«Мельница» с двумя гирями", "«Ножницы»", "«Складной нож» в положении лежа на спине", "«Складной нож» в положении на боку", "Боковые скручивания", "Жим в подъеме туловища из положения лежа", "Касания стоп", "Косые скручивания",
                    "Косые скручивания на наклонной скамье", "Наклоны в сторону с гантелей", "Наклоны в сторону со штангой", "Обратные скручивания в положении лежа", "Планка", "Повороты с блином", "Повороты со штангой сидя на скамье", "Подтягивание коленей к груди", "Подъем ног в висе на перекладине",
                    "Подъем ног в положении лежа", "Подъем ног в тренажере с упорами для локтей", "Подъем ног к перекладине", "Подъем ног лежа на горизонтальной скамье", "Подъем ног на наклонной скамье", "Подъем ягодиц", "Пресс с гимнастическим роликом", "Скручивания на наклонной скамье",
                    "Упражнение для косых мышц живота «Мост»"},
            // Мышцы Спины
            new String[]{"Горизонтальные подтягивания", "Подтягивания смешанным хватом", "Подъем гири одной рукой", "Подъем изогнутой штанги лежа на скамье", "Поочередный подъем гирь назад", "Тяга гантелей в наклоне", "Тяга гантели в наклоне", "Тяга гирь в наклоне обеими руками", "Тяга гирь в упоре лежа",
                    "Тяга на наклонной скамье", "Тяга на нижнем блоке", "Тяга нижнего блока одной рукой", "Тяга Т-штанги в положении лежа", "Тяга Т-штанги обеими руками в наклоне", "Тяга Т-штанги одной рукой в наклоне", "Тяга штанги в наклоне", "Тяга штанги в наклоне в машине Смита",
                    "Тяга штанги в наклоне обратным хватом"},
            // Трапеция
            new String[]{"Вертикальная тяга гантелей", "Вертикальная тяга нижнего блока", "Тяга гири к груди в стиле Сумо", "Тяга штанги к груди в машине Смита", "Шраги в машине Смита", "Шраги в тренажере для голеней", "Шраги на нижнем блоке", "Шраги с гантелями", "Шраги со штангой",
                    "Шраги со штангой из-за спины", "Шраги широким хватом"},
            // Трицепс
            new String[]{"JM-жим", "Жим гантелей лежа на полу", "Жим лежа на полу", "Жим лежа узким хватом в машине Смита", "Жим нижнего блока на трицепс лежа", "Жим со стоек в положении лежа", "Жим штанги лежа на скамье", "Жим штанги лежа узким хватом",
                    "Комплексное упражнение на трицепс на наклонной скамье", "Обратный жим лежа на скамье", "Отведение гантелей назад в наклоне", "Отжимания в тренажере", "Отжимания на брусьях", "Отжимания от скамьи из-за спины", "Отжимания с узким упором",
                    "Разгибание гантели из-за головы", "Разгибание гантели пронированным хватом", "Разгибание двумя руками на трицепс в наклоне", "Разгибание двумя руками на трицепс сидя в наклоне", "Разгибание на трицепс на верхнем блоке", "Разгибание на трицепс на верхнем блоке с V-рукоятью",
                    "Разгибание рук на блоке из-за головы стоя на коленях", "Разгибание штанги узким хватом в положении лежа", "Разгибания на трицепс в тренажере", "Разгибания на трицепс на верхнем блоке лежа на наклонной скамье", "Французский жим гантелями на наклонной скамье",
                    "Французский жим лежа", "Французский жим одной рукой стоя", "Французский жим с гантелей стоя", "Французский жим сидя", "Французский жим со штангой стоя"},
            // Шея
            new String[]{"Плиометрическое упражнение на укрепление мышц шеи", "Поднятие диска, лежа головой вверх на скамье", "Поднятие диска, лежа головой вниз на скамье", "Растягивание мышц шеи в стороны", "Тяга головы к груди"},
            // Широчайшая мышца спины
            new String[]{"Перекрёстная тяга на блоках", "Подтягивания", "Подтягивания нейтральным хватом", "Подтягивания обратным хватом", "Подтягивания от Рокки", "Подтягивания широким хватом", "Пуловер на наклонной скамье в тросовом тренажере", "Пуловер со штангой на прямой скамье",
                    "Тяга верхнего блока за голову", "Тяга верхнего блока к груди", "Тяга верхнего блока к груди обратным хватом", "Тяга верхнего блока к груди с V образным грифом", "Тяга верхнего блока с прямыми руками", "Тяга верхнего блока широким хватом", "Тяга к груди в гребном тренажере"},
            // Ягодицы
            new String[]{"Махи назад согнутой ногой", "Махи ногой на нижнем блоке", "Подъем ягодиц («Мост»)", "Подъем ягодиц со штангой", "Подъем ягодиц со штангой, опираясь на скамью", "Приседания стоя на коленях", "Прыжок со штангой из упора сидя", "Тяга нижнего блока между ног"},
    };

    private final Context mContext;

    int key;

    public static boolean validateExcerciseIndex(int tab, int index) {
        if (tab >= TAB_EXERCISES.length)
            return false;

        if (index >= TAB_EXERCISES[tab].length)
            return false;
        return true;
    }


    public SectionsPagerAdapter(Context context, FragmentManager fm, int key) {
        super(fm);
        mContext = context;
        this.key=key;
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(position, key);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 15;
    }
}