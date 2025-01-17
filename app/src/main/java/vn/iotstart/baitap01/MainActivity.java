package vn.iotstart.baitap01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.WindowManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().getDecorView().setSystemUiVisibility(
                android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
                        | android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_main);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        randomAndProcessArray();


    }
    private void randomAndProcessArray() {
        // Tạo mảng ArrayList kiểu số nguyên
        ArrayList<Integer> numbers = new ArrayList<>();

        // Random 10 số nguyên từ 1 đến 100
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100) + 1); // Random từ 1 đến 100
        }

        // Log danh sách ban đầu
        Log.d("ArrayList", "Mảng ban đầu: " + numbers.toString());

        // Tách số chẵn và số lẻ
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number); // Số chẵn
            } else {
                oddNumbers.add(number); // Số lẻ
            }
        }

        // In kết quả ra Log
        Log.d("ArrayList", "Số chẵn: " + evenNumbers.toString());
        Log.d("ArrayList", "Số lẻ: " + oddNumbers.toString());
    }
    private String reverseWords(String input) {
        // Chia chuỗi thành các từ
        List<String> words = Arrays.asList(input.split(" "));
        // Đảo ngược danh sách từ
        Collections.reverse(words);
        // Nối lại thành chuỗi
        return String.join(" ", words);
    }

}