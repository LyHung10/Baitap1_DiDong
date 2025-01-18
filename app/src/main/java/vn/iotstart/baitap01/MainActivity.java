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

    private EditText editTextInput;
    private Button buttonProcess;
    private TextView textViewOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Ẩn thanh trạng thái và thanh điều hướng
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Khởi tạo các view
        editTextInput = findViewById(R.id.editTextInput);
        buttonProcess = findViewById(R.id.buttonProcess);
        textViewOutput = findViewById(R.id.textViewOutput);

        // Xử lý mảng ngẫu nhiên
        randomAndProcessArray();

        // Thiết lập chức năng đảo ngược chuỗi
        setupReverseTextFeature();
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
    private void setupReverseTextFeature() {
        buttonProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextInput.getText().toString();
                if (!input.isEmpty()) {
                    String reversed = reverseAndCapitalize(input);
                    textViewOutput.setText(reversed);
                    Toast.makeText(MainActivity.this, reversed, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String reverseAndCapitalize(String input) {
        List<String> words = Arrays.asList(input.split("\\s+"));
        Collections.reverse(words);
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            reversed.append(word.toUpperCase()).append(" ");
        }
        return reversed.toString().trim();
    }

}