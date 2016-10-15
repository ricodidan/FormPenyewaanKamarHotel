package id.sch.smktelkom_mlg.tugas01.xiirpl3013.formpenyewaankamarhotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText NmPemesan;
    EditText AlmtPemesan;
    EditText ThnLahir;
    EditText LmMenginap;
    RadioButton LK, PR;
    RadioGroup RdJns;
    CheckBox Luxury, Business, Reguler;
    Spinner spProvinsi;
    Button bOK;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NmPemesan = (EditText) findViewById(R.id.editTextNmPemesan);
        AlmtPemesan = (EditText) findViewById(R.id.editTextAlmtPemesan);
        ThnLahir = (EditText) findViewById(R.id.editTextThnLahir);
        LmMenginap = (EditText) findViewById(R.id.editTextLmMenginap);
        RdJns = (RadioGroup) findViewById(R.id.radioGroupJns);
        /*LK = (RadioButton) findViewById(R.id.radioButtonLK);
        PR = (RadioButton) findViewById(R.id.radioButtonLK);*/
        Luxury = (CheckBox) findViewById(R.id.checkBoxLuxury);
        Business = (CheckBox) findViewById(R.id.checkBoxBusiness);
        Reguler = (CheckBox) findViewById(R.id.checkBoxReguler);
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proses();
            }
        });
    }

    private void proses() {
        if (isValid()) {
            String radio = null;
            if (RdJns.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(RdJns.getCheckedRadioButtonId());
                radio = rb.getText().toString();
            }
            String check = "\nKategori Kamar : \n";
            int startlen = check.length();
            if (Luxury.isChecked()) check += Luxury.getText() + "\n";
            if (Business.isChecked()) check += Business.getText() + "\n";
            if (Reguler.isChecked()) check += Reguler.getText() + "\n";
            if (check.length() == startlen) check += "Tidak Ada Pilihan";


            String nama = NmPemesan.getText().toString();
            String alamat = AlmtPemesan.getText().toString();
            int tahun = Integer.parseInt(ThnLahir.getText().toString());
            int usia = 2016 - tahun;
            String lama = LmMenginap.getText().toString();

            tvHasil.setText("Nama Pemesan : " + nama + "\nAlamat Pemesan : " + alamat +
                    "\nTahun Lahir : " + tahun + "\nUsia Anda : " + usia + "tahun" + "\nLama Menginap : " + lama + " hari" + "\nJenis Kelamin : " + radio + check
                    + "\nWilayah Provinsi : " + spProvinsi.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = NmPemesan.getText().toString();
        String tahun = ThnLahir.getText().toString();
        String alamat = AlmtPemesan.getText().toString();
        String lama = LmMenginap.getText().toString();

        if (nama.isEmpty() || tahun.isEmpty() || alamat.isEmpty() || lama.isEmpty()) {
            NmPemesan.setError("Nama belum diisi");
            AlmtPemesan.setError("Alamat Pemesan belum diisi");
            ThnLahir.setError("Tahun Lahir belum diisi");
            LmMenginap.setError("Lama Menginap belum diisi");
            valid = false;
        } else {
            NmPemesan.setError(null);
            AlmtPemesan.setError(null);
            ThnLahir.setError(null);
            LmMenginap.setError(null);
        }


        return valid;
    }
}
