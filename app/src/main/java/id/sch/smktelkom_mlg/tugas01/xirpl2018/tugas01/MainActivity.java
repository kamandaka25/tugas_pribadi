package id.sch.smktelkom_mlg.tugas01.xirpl2018.tugas01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etnama;
    TextView tvh1, tvh2,tvh3,tvh4;
    Button bok;
    RadioGroup rdjk;
    CheckBox bta, fo , pramuka;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnama = (EditText) findViewById(R.id.nama);
        rdjk = (RadioGroup) findViewById(R.id.radiogroupjk);
        bta = (CheckBox) findViewById(R.id.bta);
        fo = (CheckBox) findViewById(R.id.fo);
        pramuka = (CheckBox) findViewById(R.id.pramuka);
        bok = (Button) findViewById(R.id.hasil);
        tvh1 = (TextView) findViewById(R.id.h1);
        tvh2 = (TextView) findViewById(R.id.h2);
        tvh3 = (TextView) findViewById(R.id.h3);
        tvh4 = (TextView) findViewById(R.id.h4);
        spin = (Spinner) findViewById(R.id.spin);

        bok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
                doClick();
            }
        });

    }

    private void doClick() {
        String hasil = null;
        if (rdjk.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rdjk.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvh2.setText("Belum Memilih");
        } else {
            tvh2.setText("Gender Anda : " + hasil);
        }
        tvh3.setText("Kelas :" + spin.getSelectedItem().toString());

        String hasil4 = "Ekstrakulikuler: \n";
        int startlen = hasil4.length();
        if (pramuka.isChecked()) hasil4 += pramuka.getText() + "\n";
        if(fo.isChecked()) hasil4 += fo.getText() + "\n";
        if(bta.isChecked()) hasil4 += bta.getText() + "\n";

        if (hasil.length() == startlen) hasil4 += "Belum Memilih";
        tvh4.setText(hasil4);
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etnama.getText().toString();
            tvh1.setText("Nama Anda : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etnama.getText().toString();

        if (nama.isEmpty()) {
            etnama.setError("Nama anda belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etnama.setError("Nama Minimal 3 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        return valid;


    }
}