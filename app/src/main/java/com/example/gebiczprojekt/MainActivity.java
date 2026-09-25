package com.example.gebiczprojekt;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etName = findViewById(R.id.etName);
        EditText etSurname = findViewById(R.id.etSurname);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvMessage = findViewById(R.id.tvMessage);
        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String surname = etSurname.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();


            if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                tvMessage.setText("Uzupełnij wszystkie pola");
                return;
            }
            if (!email.contains("@")) {
                tvMessage.setText("Podaj poprawny adres email");
                return;
            }
            boolean upper = false, lower = false, special = false;
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) upper = true;
                else if (Character.isLowerCase(c)) lower = true;
                else if (!Character.isLetterOrDigit(c)) special = true;
            }
            if (password.length() < 8 || !upper || !lower || !special) {
                tvMessage.setText("Hasło musi mieć co najmniej 8 znaków duza i mala litere plus znak specjalny");
                return;
            }
            tvMessage.setText("Dane są poprawne");
        });
    }
}