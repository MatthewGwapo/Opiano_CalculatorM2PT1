import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText operand1EditText;
    private EditText operand2EditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        operand1EditText = findViewById(R.id.operand1_edittext);
        operand2EditText = findViewById(R.id.operand2_edittext);
        addButton = findViewById(R.id.add_button);
        subtractButton = findViewById(R.id.subtract_button);
        multiplyButton = findViewById(R.id.multiply_button);
        divideButton = findViewById(R.id.divide_button);
        resultTextView = findViewById(R.id.result_textview);

        // Set click listeners for the buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    private void performOperation(char operator) {
        double operand1 = Double.parseDouble(operand1EditText.getText().toString());
        double operand2 = Double.parseDouble(operand2EditText.getText().toString());
        double result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0)
                    result = operand1 / operand2;
                else
                    resultTextView.setText("Cannot divide by zero!");
                break;
        }

        resultTextView.setText("Result: " + String.valueOf(result));
    }
}

