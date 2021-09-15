package com.example.sgugit;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.sgugit.ui.main.PageViewModel;

public class Exercises_Op extends AppCompatActivity {

    private TextView text_content;
    private TextView name_exe;
    private ImageView iContent;
    private ImageView iContent_2;
    private PageViewModel pageViewModel;

    public static int[][][] EXERCISE_DESC = {
            // Бицепс (1)
            {
                // Кнопки (44)
                    {R.string.ex_b1, R.string.ex_0_1, R.drawable._1_1_1, R.drawable._1_1_2},
                    {R.string.ex_b2, R.string.ex_0_2, R.drawable._1_2___1_, R.drawable._1_2___2_},
                    {R.string.ex_b3, R.string.ex_0_3, R.drawable._1_3___1_, R.drawable._1_3___2_},
                    {R.string.ex_b4, R.string.ex_0_4, R.drawable._1_4___1_, R.drawable._1_4___2_},
                    {R.string.ex_b5, R.string.ex_0_5, R.drawable._1_5___1_, R.drawable._1_5___2_},
                    {R.string.ex_b6, R.string.ex_0_6, R.drawable._1_6___1_, R.drawable._1_6___2_},
                    {R.string.ex_b7, R.string.ex_0_7, R.drawable._1_7___1_, R.drawable._1_7___2_},
                    {R.string.ex_b8, R.string.ex_0_8, R.drawable._1_8___1_, R.drawable._1_8___2_},
                    {R.string.ex_b9, R.string.ex_0_9, R.drawable._1_9___1_, R.drawable._1_9___2_},
                    {R.string.ex_b10, R.string.ex_0_10, R.drawable._1_10___1_, R.drawable._1_10___2_},
                    {R.string.ex_b11, R.string.ex_0_11, R.drawable._1_11___1_, R.drawable._1_11___2_},
                    {R.string.ex_b12, R.string.ex_0_12, R.drawable._1_12___1_, R.drawable._1_12___2_},
                    {R.string.ex_b13, R.string.ex_0_13, R.drawable._1_13___1_, R.drawable._1_13___2_},
                    {R.string.ex_b14, R.string.ex_0_14, R.drawable._1_13___3_, R.drawable._1_13___4_},
                    {R.string.ex_b15, R.string.ex_0_15, R.drawable._1_14___1_, R.drawable._1_14___2_},
                    {R.string.ex_b16, R.string.ex_0_16, R.drawable._1_15___1_, R.drawable._1_15___2_},
                    {R.string.ex_b17, R.string.ex_0_17, R.drawable._1_16___1_, R.drawable._1_16___2_},
                    {R.string.ex_b18, R.string.ex_0_18, R.drawable._1_17___1_, R.drawable._1_17___2_},
                    {R.string.ex_b19, R.string.ex_0_19, R.drawable._1_18___1_, R.drawable._1_18___2_},
                    {R.string.ex_b20, R.string.ex_0_20, R.drawable._1_19___1_, R.drawable._1_19___2_},
                    {R.string.ex_b21, R.string.ex_0_21, R.drawable._1_20___1_, R.drawable._1_20___2_},
                    {R.string.ex_b22, R.string.ex_0_22, R.drawable._1_21___1_, R.drawable._1_21___2_},
                    {R.string.ex_b23, R.string.ex_0_23, R.drawable._1_23___3_, R.drawable._1_23___2_},
                    {R.string.ex_b24, R.string.ex_0_24, R.drawable._1_23___1_, R.drawable._1_23___4_},
                    {R.string.ex_b25, R.string.ex_0_25, R.drawable._1_24___1_, R.drawable._1_24___2_},
                    {R.string.ex_b26, R.string.ex_0_26, R.drawable._1_25___1_, R.drawable._1_25___2_},
                    {R.string.ex_b27, R.string.ex_0_27, R.drawable._1_26___1_, R.drawable._1_26___2_},
                    {R.string.ex_b28, R.string.ex_0_28, R.drawable._1_27___1_, R.drawable._1_27___2_},
                    {R.string.ex_b29, R.string.ex_0_29, R.drawable._1_28___1_, R.drawable._1_28___2_},
                    {R.string.ex_b30, R.string.ex_0_30, R.drawable._1_29___1_, R.drawable._1_29___2_},
                    {R.string.ex_b31, R.string.ex_0_31, R.drawable._1_30___1_, R.drawable._1_30___2_},
                    {R.string.ex_b32, R.string.ex_0_32, R.drawable._1_31___1_, R.drawable._1_31___2_},
                    {R.string.ex_b33, R.string.ex_0_33, R.drawable._1_32___1_, R.drawable._1_32___2_},
                    {R.string.ex_b34, R.string.ex_0_34, R.drawable._1_33___1_, R.drawable._1_33___2_},
                    {R.string.ex_b35, R.string.ex_0_35, R.drawable._1_34___1_, R.drawable._1_34___2_},
                    {R.string.ex_b36, R.string.ex_0_36, R.drawable._1_35___1_, R.drawable._1_35___2_},
                    {R.string.ex_b37, R.string.ex_0_37, R.drawable._1_36___1_, R.drawable._1_36___2_},
                    {R.string.ex_b38, R.string.ex_0_38, R.drawable._1_37___1_, R.drawable._1_37___2_},
                    {R.string.ex_b39, R.string.ex_0_39, R.drawable._1_38___1_, R.drawable._1_38___2_},
                    {R.string.ex_b40, R.string.ex_0_40, R.drawable._1_39___1_, R.drawable._1_39___2_},
                    {R.string.ex_b41, R.string.ex_0_41, R.drawable._1_40___1_, R.drawable._1_40___2_},
                    {R.string.ex_b42, R.string.ex_0_42, R.drawable._1_41___1_, R.drawable._1_41___2_},
                    {R.string.ex_b43, R.string.ex_0_43, R.drawable._1_42___1_, R.drawable._1_42___2_},
                    {R.string.ex_b44, R.string.ex_0_44, R.drawable._1_43___1_, R.drawable._1_43___2_}
            },
            // Грудь (2)
            {
                // Кнопки (31)
                    {R.string.ex_g1, R.string.ex_2_1, R.drawable._2_1___1_, R.drawable._2_1___2_},
                    {R.string.ex_g2, R.string.ex_2_2, R.drawable._2_2___1_, R.drawable._2_2___2_},
                    {R.string.ex_g3, R.string.ex_2_3, R.drawable._2_3___1_, R.drawable._2_3___2_},
                    {R.string.ex_g4, R.string.ex_2_4, R.drawable._2_4___1_, R.drawable._2_4___2_},
                    {R.string.ex_g5, R.string.ex_2_5, R.drawable._2_5___1_, R.drawable._2_5___2_},
                    {R.string.ex_g6, R.string.ex_2_6, R.drawable._2_6___1_, R.drawable._2_6___2_},
                    {R.string.ex_g7, R.string.ex_2_7, R.drawable._2_7___1_, R.drawable._2_7___2_},
                    {R.string.ex_g8, R.string.ex_2_8, R.drawable._2_8___1_, R.drawable._2_8___2_},
                    {R.string.ex_g9, R.string.ex_2_9, R.drawable._2_9___1_, R.drawable._2_9___2_},
                    {R.string.ex_g10, R.string.ex_2_10, R.drawable._2_10___1_, R.drawable._2_10___2_},
                    {R.string.ex_g11, R.string.ex_2_11, R.drawable._2_11___1_, R.drawable._2_11___2_},
                    {R.string.ex_g12, R.string.ex_2_12, R.drawable._2_12___1_, R.drawable._2_12___2_},
                    {R.string.ex_g13, R.string.ex_2_13, R.drawable._2_13___1_, R.drawable._2_13___2_},
                    {R.string.ex_g14, R.string.ex_2_14, R.drawable._2_14___1_, R.drawable._2_14___2_},
                    {R.string.ex_g15, R.string.ex_2_15, R.drawable._2_15___1_, R.drawable._2_15___2_},
                    {R.string.ex_g16, R.string.ex_2_16, R.drawable._2_16___1_, R.drawable._2_16___2_},
                    {R.string.ex_g17, R.string.ex_2_17, R.drawable._2_17___1_, R.drawable._2_17___2_},
                    {R.string.ex_g18, R.string.ex_2_18, R.drawable._2_18___1_, R.drawable._2_18___2_},
                    {R.string.ex_g19, R.string.ex_2_19, R.drawable._2_19___1_, R.drawable._2_19___2_},
                    {R.string.ex_g20, R.string.ex_2_20, R.drawable._2_20___1_, R.drawable._2_20___2_},
                    {R.string.ex_g21, R.string.ex_2_21, R.drawable._2_21___1_, R.drawable._2_21___2_},
                    {R.string.ex_g22, R.string.ex_2_22, R.drawable._2_22___1_, R.drawable._2_22___2_},
                    {R.string.ex_g23, R.string.ex_2_23, R.drawable._2_23___1_, R.drawable._2_23___2_},
                    {R.string.ex_g24, R.string.ex_2_24, R.drawable._2_24___1_, R.drawable._2_24___2_},
                    {R.string.ex_g25, R.string.ex_2_25, R.drawable._2_25___1_, R.drawable._2_25___2_},
                    {R.string.ex_g26, R.string.ex_2_26, R.drawable._2_26___1_, R.drawable._2_26___2_},
                    {R.string.ex_g27, R.string.ex_2_27, R.drawable._2_27___1_, R.drawable._2_27___2_},
                    {R.string.ex_g28, R.string.ex_2_28, R.drawable._2_28___1_, R.drawable._2_28___2_},
                    {R.string.ex_g29, R.string.ex_2_29, R.drawable._2_29___1_, R.drawable._2_29___2_},
                    {R.string.ex_g30, R.string.ex_2_30, R.drawable._2_30___1_, R.drawable._2_30___2_},
                    {R.string.ex_g31, R.string.ex_2_31, R.drawable._2_31___1_, R.drawable._2_31___2_}
            },
            // Плечи (3)
            {
                // Кнопки (49)
                    {R.string.ex_d1, R.string.ex_3_1, R.drawable._3_1___1_, R.drawable._3_1___2_},
                    {R.string.ex_d2, R.string.ex_3_2, R.drawable._3_2___1_, R.drawable._3_2___2_},
                    {R.string.ex_d3, R.string.ex_3_3, R.drawable._3_3___1_, R.drawable._3_3___2_},
                    {R.string.ex_d4, R.string.ex_3_4, R.drawable._3_4___1_, R.drawable._3_4___2_},
                    {R.string.ex_d5, R.string.ex_3_5, R.drawable._3_5___1_, R.drawable._3_5___2_},
                    {R.string.ex_d6, R.string.ex_3_6, R.drawable._3_6___1_, R.drawable._3_6___2_},
                    {R.string.ex_d7, R.string.ex_3_7, R.drawable._3_7___1_, R.drawable._3_7___2_},
                    {R.string.ex_d8, R.string.ex_3_8, R.drawable._3_8___1_, R.drawable._3_8___2_},
                    {R.string.ex_d9, R.string.ex_3_9, R.drawable._3_9___1_, R.drawable._3_9___2_},
                    {R.string.ex_d10, R.string.ex_3_10, R.drawable._3_10___1_, R.drawable._3_10___2_},
                    {R.string.ex_d11, R.string.ex_3_11, R.drawable._3_11___1_, R.drawable._3_11___2_},
                    {R.string.ex_d12, R.string.ex_3_12, R.drawable._3_12___1_, R.drawable._3_12___2_},
                    {R.string.ex_d13, R.string.ex_3_13, R.drawable._3_13___1_, R.drawable._3_13___2_},
                    {R.string.ex_d14, R.string.ex_3_14, R.drawable._3_14___1_, R.drawable._3_14___2_},
                    {R.string.ex_d15, R.string.ex_3_15, R.drawable._3_15___1_, R.drawable._3_15___2_},
                    {R.string.ex_d16, R.string.ex_3_16, R.drawable._3_16___1_, R.drawable._3_16___2_},
                    {R.string.ex_d17, R.string.ex_3_17, R.drawable._3_17___1_, R.drawable._3_17___2_},
                    {R.string.ex_d18, R.string.ex_3_18, R.drawable._3_18___1_, R.drawable._3_18___2_},
                    {R.string.ex_d19, R.string.ex_3_19, R.drawable._3_19___1_, R.drawable._3_19___2_},
                    {R.string.ex_d20, R.string.ex_3_20, R.drawable._3_20___1_, R.drawable._3_20___2_},
                    {R.string.ex_d21, R.string.ex_3_21, R.drawable._3_21___1_, R.drawable._3_21___2_},
                    {R.string.ex_d22, R.string.ex_3_22, R.drawable._3_22___1_, R.drawable._3_22___2_},
                    {R.string.ex_d23, R.string.ex_3_23, R.drawable._3_23___1_, R.drawable._3_23___2_},
                    {R.string.ex_d24, R.string.ex_3_24, R.drawable._3_24___1_, R.drawable._3_24___2_},
                    {R.string.ex_d25, R.string.ex_3_25, R.drawable._3_25___1_, R.drawable._3_25___2_},
                    {R.string.ex_d26, R.string.ex_3_26, R.drawable._3_26___1_, R.drawable._3_26___2_},
                    {R.string.ex_d27, R.string.ex_3_27, R.drawable._3_27___1_, R.drawable._3_27___2_},
                    {R.string.ex_d28, R.string.ex_3_28, R.drawable._3_28___1_, R.drawable._3_28___2_},
                    {R.string.ex_d29, R.string.ex_3_29, R.drawable._3_29___1_, R.drawable._3_29___2_},
                    {R.string.ex_d30, R.string.ex_3_30, R.drawable._3_30___1_, R.drawable._3_30___2_},
                    {R.string.ex_d31, R.string.ex_3_31, R.drawable._3_31___1_, R.drawable._3_31___2_},
                    {R.string.ex_d32, R.string.ex_3_32, R.drawable._3_32___1_, R.drawable._3_32___2_},
                    {R.string.ex_d33, R.string.ex_3_33, R.drawable._3_33___1_, R.drawable._3_33___2_},
                    {R.string.ex_d34, R.string.ex_3_34, R.drawable._3_34___1_, R.drawable._3_34___2_},
                    {R.string.ex_d35, R.string.ex_3_35, R.drawable._3_35___1_, R.drawable._3_35___2_},
                    {R.string.ex_d36, R.string.ex_3_36, R.drawable._3_36___1_, R.drawable._3_36___2_},
                    {R.string.ex_d37, R.string.ex_3_37, R.drawable._3_37___1_, R.drawable._3_37___2_},
                    {R.string.ex_d38, R.string.ex_3_38, R.drawable._3_38___1_, R.drawable._3_38___2_},
                    {R.string.ex_d39, R.string.ex_3_39, R.drawable._3_39___1_, R.drawable._3_39___2_},
                    {R.string.ex_d40, R.string.ex_3_40, R.drawable._3_40___1_, R.drawable._3_40___2_},
                    {R.string.ex_d41, R.string.ex_3_41, R.drawable._3_41___1_, R.drawable._3_41___2_},
                    {R.string.ex_d42, R.string.ex_3_42, R.drawable._3_42___1_, R.drawable._3_42___2_},
                    {R.string.ex_d43, R.string.ex_3_43, R.drawable._3_43___1_, R.drawable._3_43___2_},
                    {R.string.ex_d44, R.string.ex_3_44, R.drawable._3_44___1_, R.drawable._3_44___2_},
                    {R.string.ex_d45, R.string.ex_3_45, R.drawable._3_45___1_, R.drawable._3_45___2_},
                    {R.string.ex_d46, R.string.ex_3_46, R.drawable._3_46___1_, R.drawable._3_46___2_},
                    {R.string.ex_d47, R.string.ex_3_47, R.drawable._3_47___1_, R.drawable._3_47___2_},
                    {R.string.ex_d48, R.string.ex_3_48, R.drawable._3_48___1_, R.drawable._3_48___2_},
                    {R.string.ex_d49, R.string.ex_3_49, R.drawable._3_49___1_, R.drawable._3_49___2_}
            },
            // Задние мышцы бедра (4)
            {
                // Кнопки (17)
                    {R.string.ex_z1, R.string.ex_4_1, R.drawable._4_1___1_, R.drawable._4_1___2_},
                    {R.string.ex_z2, R.string.ex_4_2, R.drawable._4_2___1_, R.drawable._4_2___2_},
                    {R.string.ex_z3, R.string.ex_4_3, R.drawable._4_3___1_, R.drawable._4_3___2_},
                    {R.string.ex_z4, R.string.ex_4_4, R.drawable._4_4___1_, R.drawable._4_4___2_},
                    {R.string.ex_z5, R.string.ex_4_5, R.drawable._4_5___1_, R.drawable._4_5___2_},
                    {R.string.ex_z6, R.string.ex_4_6, R.drawable._4_6___1_, R.drawable._4_6___2_},
                    {R.string.ex_z7, R.string.ex_4_7, R.drawable._4_7___1_, R.drawable._4_7___2_},
                    {R.string.ex_z8, R.string.ex_4_8, R.drawable._4_8___1_, R.drawable._4_8___2_},
                    {R.string.ex_z9, R.string.ex_4_9, R.drawable._4_9___1_, R.drawable._4_9___2_},
                    {R.string.ex_z10, R.string.ex_4_10, R.drawable._4_10___1_, R.drawable._4_10___2_},
                    {R.string.ex_z11, R.string.ex_4_11, R.drawable._4_11___1_, R.drawable._4_11___2_},
                    {R.string.ex_z12, R.string.ex_4_12, R.drawable._4_12___1_, R.drawable._4_12___2_},
                    {R.string.ex_z13, R.string.ex_4_13, R.drawable._4_13___1_, R.drawable._4_13___2_},
                    {R.string.ex_z14, R.string.ex_4_14, R.drawable._4_14___1_, R.drawable._4_14___2_},
                    {R.string.ex_z15, R.string.ex_4_15, R.drawable._4_15___1_, R.drawable._4_15___2_},
                    {R.string.ex_z16, R.string.ex_4_16, R.drawable._4_16___1_, R.drawable._4_16___2_},
                    {R.string.ex_z17, R.string.ex_4_17, R.drawable._4_17___1_, R.drawable._4_17___2_}
            },
            // Икры (5)
            {
                // Кнопки (10)
                    {R.string.ex_i1, R.string.ex_5_1, R.drawable._5_1___1_, R.drawable._5_1___2_},
                    {R.string.ex_i2, R.string.ex_5_2, R.drawable._5_2___1_, R.drawable._5_2___2_},
                    {R.string.ex_i3, R.string.ex_5_3, R.drawable._5_3___1_, R.drawable._5_3___2_},
                    {R.string.ex_i4, R.string.ex_5_4, R.drawable._5_4___1_, R.drawable._5_4___2_},
                    {R.string.ex_i5, R.string.ex_5_5, R.drawable._5_5___1_, R.drawable._5_5___2_},
                    {R.string.ex_i6, R.string.ex_5_6, R.drawable._5_6___1_, R.drawable._5_6___2_},
                    {R.string.ex_i7, R.string.ex_5_7, R.drawable._5_7___1_, R.drawable._5_7___2_},
                    {R.string.ex_i8, R.string.ex_5_8, R.drawable._5_8___1_, R.drawable._5_8___2_},
                    {R.string.ex_i9, R.string.ex_5_9, R.drawable._5_9___1_, R.drawable._5_9___2_},
                    {R.string.ex_i10, R.string.ex_5_10, R.drawable._5_10___1_, R.drawable._5_10___2_}
            },
            // Квадрицепс (6)
            {
                // Кнопки (39)
                    {R.string.ex_k1, R.string.ex_6_1, R.drawable._6_1___1_, R.drawable._6_1___2_},
                    {R.string.ex_k2, R.string.ex_6_2, R.drawable._6_2___1_, R.drawable._6_2___2_},
                    {R.string.ex_k3, R.string.ex_6_3, R.drawable._6_3___1_, R.drawable._6_3___2_},
                    {R.string.ex_k4, R.string.ex_6_4, R.drawable._6_4___1_, R.drawable._6_4___2_},
                    {R.string.ex_k5, R.string.ex_6_5, R.drawable._6_5___1_, R.drawable._6_5___2_},
                    {R.string.ex_k6, R.string.ex_6_6, R.drawable._6_6___1_, R.drawable._6_6___2_},
                    {R.string.ex_k7, R.string.ex_6_7, R.drawable._6_7___1_, R.drawable._6_7___2_},
                    {R.string.ex_k8, R.string.ex_6_8, R.drawable._6_8___1_, R.drawable._6_8___2_},
                    {R.string.ex_k9, R.string.ex_6_9, R.drawable._6_9___1_, R.drawable._6_9___2_},
                    {R.string.ex_k10, R.string.ex_6_10, R.drawable._6_10___1_, R.drawable._6_10___2_},
                    {R.string.ex_k11, R.string.ex_6_11, R.drawable._6_11___1_, R.drawable._6_11___2_},
                    {R.string.ex_k12, R.string.ex_6_12, R.drawable._6_12___1_, R.drawable._6_12___2_},
                    {R.string.ex_k13, R.string.ex_6_13, R.drawable._6_13___1_, R.drawable._6_13___2_},
                    {R.string.ex_k14, R.string.ex_6_14, R.drawable._6_14___1_, R.drawable._6_14___2_},
                    {R.string.ex_k15, R.string.ex_6_15, R.drawable._6_15___1_, R.drawable._6_15___2_},
                    {R.string.ex_k16, R.string.ex_6_16, R.drawable._6_16___1_, R.drawable._6_16___2_},
                    {R.string.ex_k17, R.string.ex_6_17, R.drawable._6_17___1_, R.drawable._6_17___2_},
                    {R.string.ex_k18, R.string.ex_6_18, R.drawable._6_18___1_, R.drawable._6_18___2_},
                    {R.string.ex_k19, R.string.ex_6_19, R.drawable._6_19___1_, R.drawable._6_19___2_},
                    {R.string.ex_k20, R.string.ex_6_20, R.drawable._6_20___1_, R.drawable._6_20___2_},
                    {R.string.ex_k21, R.string.ex_6_21, R.drawable._6_21___1_, R.drawable._6_21___2_},
                    {R.string.ex_k22, R.string.ex_6_22, R.drawable._6_22___1_, R.drawable._6_22___2_},
                    {R.string.ex_k23, R.string.ex_6_23, R.drawable._6_23___1_, R.drawable._6_23___2_},
                    {R.string.ex_k24, R.string.ex_6_24, R.drawable._6_24___1_, R.drawable._6_24___2_},
                    {R.string.ex_k25, R.string.ex_6_25, R.drawable._6_25___1_, R.drawable._6_25___2_},
                    {R.string.ex_k26, R.string.ex_6_26, R.drawable._6_26___1_, R.drawable._6_26___2_},
                    {R.string.ex_k27, R.string.ex_6_27, R.drawable._6_27___1_, R.drawable._6_27___2_},
                    {R.string.ex_k28, R.string.ex_6_28, R.drawable._6_28___1_, R.drawable._6_28___2_},
                    {R.string.ex_k29, R.string.ex_6_29, R.drawable._6_29___1_, R.drawable._6_29___2_},
                    {R.string.ex_k30, R.string.ex_6_30, R.drawable._6_30___1_, R.drawable._6_30___2_},
                    {R.string.ex_k31, R.string.ex_6_31, R.drawable._6_31___1_, R.drawable._6_31___2_},
                    {R.string.ex_k32, R.string.ex_6_32, R.drawable._6_32___1_, R.drawable._6_32___2_},
                    {R.string.ex_k33, R.string.ex_6_33, R.drawable._6_33__1_, R.drawable._6_33__2_},
                    {R.string.ex_k34, R.string.ex_6_34, R.drawable._6_34___1_, R.drawable._6_34___2_},
                    {R.string.ex_k35, R.string.ex_6_35, R.drawable._6_35___1_, R.drawable._6_35___2_},
                    {R.string.ex_k36, R.string.ex_6_36, R.drawable._6_36___1_, R.drawable._6_36___2_},
                    {R.string.ex_k37, R.string.ex_6_37, R.drawable._6_37___1_, R.drawable._6_37___2_},
                    {R.string.ex_k38, R.string.ex_6_38, R.drawable._6_38___1_, R.drawable._6_38___2_},
                    {R.string.ex_k39, R.string.ex_6_39, R.drawable._6_39___1_, R.drawable._6_39___2_}

            },
            // Поясница (7)
            {
                // Кнопки (7)
                    {R.string.ex_pa1, R.string.ex_7_1, R.drawable._7_1___1_, R.drawable._7_1___2_},
                    {R.string.ex_pa2, R.string.ex_7_2, R.drawable._7_2___1_, R.drawable._7_2___2_},
                    {R.string.ex_pa3, R.string.ex_7_3, R.drawable._7_3___1_, R.drawable._7_3___2_},
                    {R.string.ex_pa4, R.string.ex_7_4, R.drawable._7_4___1_, R.drawable._7_4___2_},
                    {R.string.ex_pa5, R.string.ex_7_5, R.drawable._7_5___1_, R.drawable._7_5___2_},
                    {R.string.ex_pa6, R.string.ex_7_6, R.drawable._7_6___1_, R.drawable._7_6___2_},
                    {R.string.ex_pa7, R.string.ex_7_7, R.drawable._7_7___1_, R.drawable._7_7___2_}
            },
            // Поредплечье (8)
            {
                    // Кнопки (16)
                    {R.string.ex_pe1, R.string.ex_8_1, R.drawable._8_1___1_, R.drawable._8_1___2_},
                    {R.string.ex_pe2, R.string.ex_8_2, R.drawable._8_2___1_, R.drawable._8_2___2_},
                    {R.string.ex_pe3, R.string.ex_8_3, R.drawable._8_3___1_, R.drawable._8_3___2_},
                    {R.string.ex_pe4, R.string.ex_8_4, R.drawable._8_4___1_, R.drawable._8_4___2_},
                    {R.string.ex_pe5, R.string.ex_8_5, R.drawable._8_5___1_, R.drawable._8_5___2_},
                    {R.string.ex_pe6, R.string.ex_8_6, R.drawable._8_6___1_, R.drawable._8_6___2_},
                    {R.string.ex_pe7, R.string.ex_8_7, R.drawable._8_7___1_, R.drawable._8_7___2_},
                    {R.string.ex_pe8, R.string.ex_8_8, R.drawable._8_8___1_, R.drawable._8_8___2_},
                    {R.string.ex_pe9, R.string.ex_8_9, R.drawable._8_9___1_, R.drawable._8_9___2_},
                    {R.string.ex_pe10, R.string.ex_8_10, R.drawable._8_10___1_, R.drawable._8_10___2_},
                    {R.string.ex_pe11, R.string.ex_8_11, R.drawable._8_11___1_, R.drawable._8_11___2_},
                    {R.string.ex_pe12, R.string.ex_8_12, R.drawable._8_12___1_, R.drawable._8_12___2_},
                    {R.string.ex_pe13, R.string.ex_8_13, R.drawable._8_13___1_, R.drawable._8_13___2_},
                    {R.string.ex_pe14, R.string.ex_8_14, R.drawable._8_14___1_, R.drawable._8_14___2_},
                    {R.string.ex_pe15, R.string.ex_8_15, R.drawable._8_15___1_, R.drawable._8_15___2_},
                    {R.string.ex_pe16, R.string.ex_8_16, R.drawable._8_16___1_, R.drawable._8_16___2_}
            },
            // Пресс (9)
            {
                // Кнопки (28)
                    {R.string.ex_ps1, R.string.ex_9_1, R.drawable._9_1___1_, R.drawable._9_1___2_},
                    {R.string.ex_ps2, R.string.ex_9_2, R.drawable._9_2___1_, R.drawable._9_2___2_},
                    {R.string.ex_ps3, R.string.ex_9_3, R.drawable._9_3___1_, R.drawable._9_3___2_},
                    {R.string.ex_ps4, R.string.ex_9_4, R.drawable._9_4___1_, R.drawable._9_4___2_},
                    {R.string.ex_ps5, R.string.ex_9_5, R.drawable._9_5___1_, R.drawable._9_5___2_},
                    {R.string.ex_ps6, R.string.ex_9_6, R.drawable._9_6___1_, R.drawable._9_6___2_},
                    {R.string.ex_ps7, R.string.ex_9_7, R.drawable._9_7___1_, R.drawable._9_7___2_},
                    {R.string.ex_ps8, R.string.ex_9_8, R.drawable._9_8___1_, R.drawable._9_8___2_},
                    {R.string.ex_ps9, R.string.ex_9_9, R.drawable._9_9___1_, R.drawable._9_9___2_},
                    {R.string.ex_ps10, R.string.ex_9_10, R.drawable._9_10___1_, R.drawable._9_10___2_},
                    {R.string.ex_ps11, R.string.ex_9_11, R.drawable._9_11___1_, R.drawable._9_11___2_},
                    {R.string.ex_ps12, R.string.ex_9_12, R.drawable._9_12___1_, R.drawable._9_12___2_},
                    {R.string.ex_ps13, R.string.ex_9_13, R.drawable._9_13___1_, R.drawable._9_13___2_},
                    {R.string.ex_ps14, R.string.ex_9_14, R.drawable._9_14___1_, R.drawable._9_14___2_},
                    {R.string.ex_ps15, R.string.ex_9_15, R.drawable._9_15___1_, R.drawable._9_15___2_},
                    {R.string.ex_ps16, R.string.ex_9_16, R.drawable._9_16___1_, R.drawable._9_16___2_},
                    {R.string.ex_ps17, R.string.ex_9_17, R.drawable._9_17___1_, R.drawable._9_17___2_},
                    {R.string.ex_ps18, R.string.ex_9_18, R.drawable._9_18___1_, R.drawable._9_18___2_},
                    {R.string.ex_ps19, R.string.ex_9_19, R.drawable._9_19___1_, R.drawable._9_19___2_},
                    {R.string.ex_ps20, R.string.ex_9_20, R.drawable._9_20___1_, R.drawable._9_20___2_},
                    {R.string.ex_ps21, R.string.ex_9_21, R.drawable._9_21___1_, R.drawable._9_21___2_},
                    {R.string.ex_ps22, R.string.ex_9_22, R.drawable._9_22___1_, R.drawable._9_22___2_},
                    {R.string.ex_ps23, R.string.ex_9_23, R.drawable._9_23___1_, R.drawable._9_23___2_},
                    {R.string.ex_ps24, R.string.ex_9_24, R.drawable._9_24___1_, R.drawable._9_24___2_},
                    {R.string.ex_ps25, R.string.ex_9_25, R.drawable._9_25___1_, R.drawable._9_25___2_},
                    {R.string.ex_ps26, R.string.ex_9_26, R.drawable._9_26___1_, R.drawable._9_26___2_},
                    {R.string.ex_ps27, R.string.ex_9_27, R.drawable._9_27___1_, R.drawable._9_27___2_},
                    {R.string.ex_ps28, R.string.ex_9_28, R.drawable._9_28___1_, R.drawable._9_28___2_}
            },
            // Мышцы Спины (10)
            {
                // Кнопки (18)
                    {R.string.ex_m1, R.string.ex_10_1, R.drawable._10_1___1_, R.drawable._10_1___2_},
                    {R.string.ex_m2, R.string.ex_10_2, R.drawable._10_2__1_, R.drawable._10_2__2_},
                    {R.string.ex_m3, R.string.ex_10_3, R.drawable._10_3___1_, R.drawable._10_3___2_},
                    {R.string.ex_m4, R.string.ex_10_4, R.drawable._10_4___1_, R.drawable._10_4___2_},
                    {R.string.ex_m5, R.string.ex_10_5, R.drawable._10_5___1_, R.drawable._10_5___2_},
                    {R.string.ex_m6, R.string.ex_10_6, R.drawable._10_6___1_, R.drawable._10_6___2_},
                    {R.string.ex_m7, R.string.ex_10_7, R.drawable._10_7___1_, R.drawable._10_7___2_},
                    {R.string.ex_m8, R.string.ex_10_8, R.drawable._10_8___1_, R.drawable._10_8___2_},
                    {R.string.ex_m9, R.string.ex_10_9, R.drawable._10_9__1_, R.drawable._10_9__2_},
                    {R.string.ex_m10, R.string.ex_10_10, R.drawable._10_10___1_, R.drawable._10_10___2_},
                    {R.string.ex_m11, R.string.ex_10_11, R.drawable._10_11___1_, R.drawable._10_11___2_},
                    {R.string.ex_m12, R.string.ex_10_12, R.drawable._10_12___1_, R.drawable._10_12___2_},
                    {R.string.ex_m13, R.string.ex_10_13, R.drawable._10_13___1_, R.drawable._10_13___2_},
                    {R.string.ex_m14, R.string.ex_10_14, R.drawable._10_14___1_, R.drawable._10_14___2_},
                    {R.string.ex_m15, R.string.ex_10_15, R.drawable._10_15___1_, R.drawable._10_15___2_},
                    {R.string.ex_m16, R.string.ex_10_16, R.drawable._10_16___1_, R.drawable._10_16___2_},
                    {R.string.ex_m17, R.string.ex_10_17, R.drawable._10_17___1_, R.drawable._10_17___2_},
                    {R.string.ex_m18, R.string.ex_10_18, R.drawable._10_18___1_, R.drawable._10_18___2_}
            },
            // Трапеция (11)
            {
                // Кнопки (11)
                    {R.string.ex_ta1, R.string.ex_11_1, R.drawable._11_1___1_, R.drawable._11_1___2_},
                    {R.string.ex_ta2, R.string.ex_11_2, R.drawable._11_2___1_, R.drawable._11_2___2_},
                    {R.string.ex_ta3, R.string.ex_11_3, R.drawable._11_3___1_, R.drawable._11_3___2_},
                    {R.string.ex_ta4, R.string.ex_11_4, R.drawable._11_4___1_, R.drawable._11_4___2_},
                    {R.string.ex_ta5, R.string.ex_11_5, R.drawable._11_5___1_, R.drawable._11_5___2_},
                    {R.string.ex_ta6, R.string.ex_11_6, R.drawable._11_6___1_, R.drawable._11_6___2_},
                    {R.string.ex_ta7, R.string.ex_11_7, R.drawable._11_7__1_, R.drawable._11_7__2_},
                    {R.string.ex_ta8, R.string.ex_11_8, R.drawable._11_8___1_, R.drawable._11_8___2_},
                    {R.string.ex_ta9, R.string.ex_11_9, R.drawable._11_9___1_, R.drawable._11_9___2_},
                    {R.string.ex_ta10, R.string.ex_10_11, R.drawable._11_10___1_, R.drawable._11_10___2_},
                    {R.string.ex_ta11, R.string.ex_11_11, R.drawable._11_11___1_, R.drawable._11_11___2_}
            },
            // Трицепс (12)
            {
               // Кнопки (31)
                    {R.string.ex_ts1, R.string.ex_12_1, R.drawable._12_1___1_, R.drawable._12_1___2_},
                    {R.string.ex_ts2, R.string.ex_12_2, R.drawable._12_2___1_, R.drawable._12_2___2_},
                    {R.string.ex_ts3, R.string.ex_12_3, R.drawable._12_3___1_, R.drawable._12_3___2_},
                    {R.string.ex_ts4, R.string.ex_12_4, R.drawable._12_4___1_, R.drawable._12_4___2_},
                    {R.string.ex_ts5, R.string.ex_12_5, R.drawable._12_5___1_, R.drawable._12_5___2_},
                    {R.string.ex_ts6, R.string.ex_12_6, R.drawable._12_6___1_, R.drawable._12_6___2_},
                    {R.string.ex_ts7, R.string.ex_12_7, R.drawable._12_7___1_, R.drawable._12_7___2_},
                    {R.string.ex_ts8, R.string.ex_12_8, R.drawable._12_8___1_, R.drawable._12_8___2_},
                    {R.string.ex_ts9, R.string.ex_12_9, R.drawable._12_9___1_, R.drawable._12_9___2_},
                    {R.string.ex_ts10, R.string.ex_12_10, R.drawable._12_10___1_, R.drawable._12_10___2_},
                    {R.string.ex_ts11, R.string.ex_12_11, R.drawable._12_11___1_, R.drawable._12_11___2_},
                    {R.string.ex_ts12, R.string.ex_12_12, R.drawable._12_12___1_, R.drawable._12_12___2_},
                    {R.string.ex_ts13, R.string.ex_12_13, R.drawable._12_13___1_, R.drawable._12_13___2_},
                    {R.string.ex_ts14, R.string.ex_12_14, R.drawable._12_14___1_, R.drawable._12_14___2_},
                    {R.string.ex_ts15, R.string.ex_12_15, R.drawable._12_15___1_, R.drawable._12_15___2_},
                    {R.string.ex_ts16, R.string.ex_12_16, R.drawable._12_16___1_, R.drawable._12_16___2_},
                    {R.string.ex_ts17, R.string.ex_12_17, R.drawable._12_17___1_, R.drawable._12_17___2_},
                    {R.string.ex_ts18, R.string.ex_12_18, R.drawable._12_18___1_, R.drawable._12_18___2_},
                    {R.string.ex_ts19, R.string.ex_12_19, R.drawable._12_19___1_, R.drawable._12_19___2_},
                    {R.string.ex_ts20, R.string.ex_12_20, R.drawable._12_20___1_, R.drawable._12_20___2_},
                    {R.string.ex_ts21, R.string.ex_12_21, R.drawable._12_21___1_, R.drawable._12_21___2_},
                    {R.string.ex_ts22, R.string.ex_12_22, R.drawable._12_22___1_, R.drawable._12_22___2_},
                    {R.string.ex_ts23, R.string.ex_12_23, R.drawable._12_23___1_, R.drawable._12_23___2_},
                    {R.string.ex_ts24, R.string.ex_12_24, R.drawable._12_24___1_, R.drawable._12_24___2_},
                    {R.string.ex_ts25, R.string.ex_12_25, R.drawable._12_25___1_, R.drawable._12_25___2_},
                    {R.string.ex_ts26, R.string.ex_12_26, R.drawable._12_26___1_, R.drawable._12_26___2_},
                    {R.string.ex_ts27, R.string.ex_12_27, R.drawable._12_27___1_, R.drawable._12_27___2_},
                    {R.string.ex_ts28, R.string.ex_12_28, R.drawable._12_28___1_, R.drawable._12_28___2_},
                    {R.string.ex_ts29, R.string.ex_12_29, R.drawable._12_29___1_, R.drawable._12_29___2_},
                    {R.string.ex_ts30, R.string.ex_12_30, R.drawable._12_30___1_, R.drawable._12_30___2_},
                    {R.string.ex_ts31, R.string.ex_12_31, R.drawable._12_31___1_, R.drawable._12_31___2_}
            },
            // Шея(13)
            {
                // Кнопки (5)
                    {R.string.ex_h1, R.string.ex_13_1, R.drawable._13_1_1, R.drawable._13_1_2},
                    {R.string.ex_h2, R.string.ex_13_2, R.drawable._13_2_1, R.drawable._13_2_2},
                    {R.string.ex_h3, R.string.ex_13_3, R.drawable._13_3_1, R.drawable._13_3_2},
                    {R.string.ex_h4, R.string.ex_13_4, R.drawable._13_4_1, R.drawable._13_4_2},
                    {R.string.ex_h5, R.string.ex_13_5, R.drawable._13_5_1, R.drawable._13_5_2}
            },
            // Широчайшивя мышца спины (14)
            {
                // Кнопки (15)
                    {R.string.ex_hs1, R.string.ex_14_1, R.drawable._14_1_1, R.drawable._14_1_2},
                    {R.string.ex_hs2, R.string.ex_14_2, R.drawable._14_2_1, R.drawable._14_2_2},
                    {R.string.ex_hs3, R.string.ex_14_3, R.drawable._14_3_1, R.drawable._14_3_2},
                    {R.string.ex_hs4, R.string.ex_14_4, R.drawable._14_4_1, R.drawable._14_4_2},
                    {R.string.ex_hs5, R.string.ex_14_5, R.drawable._14_5_1, R.drawable._14_5_2},
                    {R.string.ex_hs6, R.string.ex_14_6, R.drawable._14_6_1, R.drawable._14_6_2},
                    {R.string.ex_hs7, R.string.ex_14_7, R.drawable._14_7_1, R.drawable._14_7_2},
                    {R.string.ex_hs8, R.string.ex_14_8, R.drawable._14_8_1, R.drawable._14_8_2},
                    {R.string.ex_hs9, R.string.ex_14_9, R.drawable._14_9_1, R.drawable._14_9_2},
                    {R.string.ex_hs10, R.string.ex_14_10, R.drawable._14_10_1, R.drawable._14_10_2},
                    {R.string.ex_hs11, R.string.ex_14_11, R.drawable._14_11_1, R.drawable._14_11_2},
                    {R.string.ex_hs12, R.string.ex_14_12, R.drawable._14_12_1, R.drawable._14_12_2},
                    {R.string.ex_hs13, R.string.ex_14_13, R.drawable._14_13_1, R.drawable._14_13_2},
                    {R.string.ex_hs14, R.string.ex_14_14, R.drawable._14_14_1, R.drawable._14_14_2},
                    {R.string.ex_hs15, R.string.ex_14_15, R.drawable._14_15_1, R.drawable._14_15_2}
            },
            // Ягодицы (15)
            {
                // Кнопки (8)
                    {R.string.ex_a1, R.string.ex_15_1, R.drawable._15_1_1, R.drawable._15_1_2},
                    {R.string.ex_a2, R.string.ex_15_2, R.drawable._15_2_1, R.drawable._15_2_2},
                    {R.string.ex_a3, R.string.ex_15_3, R.drawable._15_3_1, R.drawable._15_3_2},
                    {R.string.ex_a4, R.string.ex_15_4, R.drawable._15_4_1, R.drawable._15_4_2},
                    {R.string.ex_a5, R.string.ex_15_5, R.drawable._15_5_1, R.drawable._15_5_2},
                    {R.string.ex_a6, R.string.ex_15_6, R.drawable._15_6_1, R.drawable._15_6_2},
                    {R.string.ex_a7, R.string.ex_15_7, R.drawable._15_7_1, R.drawable._15_7_2},
                    {R.string.ex_a8, R.string.ex_15_8, R.drawable._15_8_1, R.drawable._15_8_2},
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises__op);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.m_e);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        name_exe = findViewById(R.id.text_name_exe);
        text_content = findViewById(R.id.text_exe);
        iContent = findViewById(R.id.im_ex_1);
        iContent_2 = findViewById(R.id.im_ex_2);
        reciveIntent();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void reciveIntent() {
        Intent i = getIntent();
        int tab_index = 0;
        int pos_index = 0;

        if (i != null) {
            tab_index = i.getIntExtra("category", 0);
            pos_index = i.getIntExtra("position", 0);
        }
        name_exe.setText(EXERCISE_DESC[tab_index][pos_index][0]);
        text_content.setText(EXERCISE_DESC[tab_index][pos_index][1]);
        iContent.setImageResource(EXERCISE_DESC[tab_index][pos_index][2]);
        iContent_2.setImageResource(EXERCISE_DESC[tab_index][pos_index][3]);
    }




    public void onClickCopy(View view) {
        Intent i = getIntent();
        int key;
        key = i.getIntExtra("key", 5);
        if (key==666)
        {
            // Копирование названия
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            Toast.makeText(this, "Название упражнения скопировано", Toast.LENGTH_LONG).show();
            ClipData clip = ClipData.newPlainText("", name_exe.getText().toString());
            clipboard.setPrimaryClip(clip);
            Context context = view.getContext();
            Intent intent = new Intent(context, ListExercises.class);
            intent.putExtra("key_", 777);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }else{
        }

    }



}