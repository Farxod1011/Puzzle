package uz.farxod.puzzle;

import static uz.farxod.puzzle.R.drawable.not_back;
import static uz.farxod.puzzle.databinding.ActivityMainBinding.inflate;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import uz.farxod.puzzle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int click = 0;
    String[] sort = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0); //inversiyani xisoblash uchun raqamli massiv


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView t1 = findViewById(R.id.t1);
        TextView t2 = findViewById(R.id.t10);
        TextView t3 = findViewById(R.id.t11);
        TextView t4 = findViewById(R.id.t12);
        TextView t5 = findViewById(R.id.t13);
        TextView t6 = findViewById(R.id.t14);
        TextView t7 = findViewById(R.id.t15);
        TextView t8 = findViewById(R.id.t16);
        TextView t9 = findViewById(R.id.t2);
        TextView t10 =findViewById( R.id.t3);
        TextView t11 =findViewById( R.id.t4);
        TextView t12 =findViewById( R.id.t5);
        TextView t13 =findViewById( R.id.t6);
        TextView t14 =findViewById( R.id.t7);
        TextView t15 =findViewById( R.id.t8);
        TextView t16 =findViewById( R.id.t9);

        t1.setOnClickListener(v ->{
            firstLast(t1, true);
        click(t1);
        });
        t2.setOnClickListener(v ->{
            shimolJanub(t2, true);
        click(t2);
        });
        t3.setOnClickListener(v ->{
            shimolJanub(t3, true);
        click(t3);
        });
        t4.setOnClickListener(v ->{
            fourThurt(t4, true);
        click(t4);
        });
        t5.setOnClickListener(v ->{
            sharqGarb(t5, true);
        click(t5);
        });
        t6.setOnClickListener(v ->{
            centerMethod(t6);
        click(t6);
        });
        t7.setOnClickListener(v ->{
            centerMethod(t7);
        click(t7);
        });
        t8.setOnClickListener(v ->{
            sharqGarb(t8, false);
        click(t8);
        });
        t9.setOnClickListener(v ->{
            sharqGarb(t9, true);
        click(t9);
        });
        t10.setOnClickListener(v ->{
            centerMethod(t10);
        click(t10);
        });
        t11.setOnClickListener(v ->{
            centerMethod(t11);
        click(t11);
        });
        t12.setOnClickListener(v ->{
            sharqGarb(t12, false);
        click(t12);
        });
        t13.setOnClickListener(v ->{
            fourThurt(t13, false);
        click(t13);
        });
        t14.setOnClickListener(v ->{
            shimolJanub(t14, false);
        click(t14);
        });
        t15.setOnClickListener(v ->{
            shimolJanub(t15, false);
        click(t15);
        });
        t16.setOnClickListener(v ->{
            firstLast(t16, false);
        click(t16);
        });

        binding.shuffle.setOnClickListener(z->{
            shuffle();
            click=0;
            binding.click.setText("0");
        });


    }

    void centerMethod(TextView byId){
        int id = byId.getId();  //bosilgan layoutni id-sini oldik
        String text = (String) byId.getText(); //bosilgan layoutni tekstini oldik
        TextView t = findViewById(id-1);
        TextView y = findViewById(id+1);
        TextView u = findViewById(id-4);
        TextView o = findViewById(id+4);

      if(t.getText().length()==0){ //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
          t.setText(text);  //ikkalasini tekstini almashtir
      //    t.setBackground(Drawable.createFromPath("@drawable/back_layout"));
          byId.setText("");
         // byId.setBackground(Drawable.createFromPath("@drawable/not_back"));

      } else if (y.getText().length()==0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
          y.setText(text);  //ikkalasini tekstini almashtir
      //    y.setBackground(Drawable.createFromPath("@drawable/back_layout"));
          byId.setText("");
         // byId.setBackground(Drawable.createFromPath("@drawable/not_back"));

      } else if (u.getText().length()==0){ //agar bosilgan layoutni ustidagi bo'sh bo'lsa
          u.setText(text);  //ikkalasini tekstini almashtir
      //    u.setBackground(Drawable.createFromPath("@drawable/back_layout"));
          byId.setText("");
         // byId.setBackground(Drawable.createFromPath("@drawable/not_back"));

      } else if (o.getText().length()==0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
          o.setText(text);  //ikkalasini tekstini almashtir
      //    o.setBackground(Drawable.createFromPath("@drawable/back_layout"));
          byId.setText("");
         // byId.setBackground(Drawable.createFromPath("@drawable/not_back"));

      }
        sort();
    }
    void firstLast(TextView byId, boolean bool){
        int id = byId.getId();  //bosilgan layoutni id-sini oldik
        String text = (String) byId.getText(); //bosilgan layoutni tekstini oldik
        TextView t = findViewById(id-1);
        TextView y = findViewById(id+1);
        TextView u = findViewById(id-4);
        TextView o = findViewById(id+4);

        if(!bool){ //agar 1-chi layout bosilsa
        if(t.getText().length()==0){ //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
            t.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        }  else if (u.getText().length()==0){ //agar bosilgan layoutni ustidagi bo'sh bo'lsa
            u.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        } }
        else { //agar 16-chi layout bosilsa
        if (y.getText().length()==0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
            y.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        }else if (o.getText().length()==0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
            o.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        } }
        sort();
    }
    void fourThurt(TextView byId, boolean bool){
        int id = byId.getId();  //bosilgan layoutni id-sini oldik
        String text = (String) byId.getText(); //bosilgan layoutni tekstini oldik
        TextView t = findViewById(id-1);
        TextView y = findViewById(id+1);
        TextView u = findViewById(id-4);
        TextView o = findViewById(id+4);

        if(bool){
        if(t.getText().length()==0){ //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
            t.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        } else if (o.getText().length()==0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
            o.setText(text);  //ikkalasini tekstini almashtir
            byId.setText("");
            //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
        } }
        else {
            if (y.getText().length()==0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
                y.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (u.getText().length()==0){ //agar bosilgan layoutni ustidagi bo'sh bo'lsa
                u.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            }
        }
        sort();
    }
    void shimolJanub(TextView byId, boolean bool){
        int id = byId.getId();  //bosilgan layoutni id-sini oldik
        String text = (String) byId.getText(); //bosilgan layoutni tekstini oldik
        TextView t = findViewById(id-1);
        TextView y = findViewById(id+1);
        TextView u = findViewById(id-4);
        TextView o = findViewById(id+4);

        if(bool) {
            if (t.getText().length() == 0) { //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
                t.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (y.getText().length() == 0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
                y.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
            } else if (o.getText().length() == 0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
                o.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            }
        } else {
            if (t.getText().length() == 0) { //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
                t.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (y.getText().length() == 0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
                y.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (u.getText().length()==0){ //agar bosilgan layoutni ustidagi bo'sh bo'lsa
                u.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            }
        }
        sort();
    }
    void sharqGarb(TextView byId, boolean bool){
        int id = byId.getId();  //bosilgan layoutni id-sini oldik
        String text = (String) byId.getText(); //bosilgan layoutni tekstini oldik
        TextView t = findViewById(id-1);
        TextView y = findViewById(id+1);
        TextView u = findViewById(id-4);
        TextView o = findViewById(id+4);

        if(bool) {
            if (y.getText().length() == 0) { //agar bosilgan layoutdan kiyingisi bo'sh bo'lsa
                y.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (u.getText().length() == 0) { //agar bosilgan layoutni ustidagi bo'sh bo'lsa
                u.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (o.getText().length() == 0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
                o.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            }
        }else {
            if (t.getText().length() == 0) { //agar bosilgan layoutdan oldindagi bo'sh bo'lsa
                t.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (u.getText().length() == 0) { //agar bosilgan layoutni ustidagi bo'sh bo'lsa
                u.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            } else if (o.getText().length() == 0) { //agar bosilgan layoutni tagidagi bo'sh bo'lsa
                o.setText(text);  //ikkalasini tekstini almashtir
                byId.setText("");
                //byId.setBackground(Drawable.createFromPath("#FFBB86FC"));
            }
        }
        sort();
    }
    void sort(){
        int correct = 0;    //to'g'ri tartibda turgan yacheykalar soni
        int id = binding.t1.getId(); //birinchi yacheyka id-sini saqlab olamiz
        for(int i=0; i<sort.length; i++) {
            TextView t = findViewById(id+i); //shu id-dagi TextView-ni t-ga o'zlashtirib olamiz
            if(t.getText().equals(sort[i])){ //agar ekrandagi yacheyka sort-massivi bilan bir xil ketmeketlikda kelsa
                correct++;  //ni 1-ga oshir
            }
        }
        if(correct==16){    //agar correct 16 bo'lsa Toast - ni chiqaramiz
            Toast.makeText(this,"URA.. siz yutdingiz", Toast.LENGTH_SHORT).show();
            click=0;
            binding.click.setText("0");
        }
    }
    void shuffle(){
        int click1 = 0;
        int count = 0;  //inversiya soni xisoblanadi
        int nullPosition = 0; //bo'sh joyni indexi saqlanadi
        int id = binding.t1.getId(); //birinchi yacheyka id-sini saqlab olamiz
        boolean continues = true;

        while (continues){
            Collections.shuffle(list);
            for (int i=0; i<list.size(); i++){
                for(int j=0; j<i; j++){ //inversiyani bittalab bir-biri bilan tekshiramiz
                    if(list.get(i) > list.get(j)){
                        if(list.get(i)==0)
                            nullPosition = i;
                        if(list.get(i)==0 || list.get(j)==0) { continue; } //bo'sh katak kelsa tashlab ketish
                        else count++;   //aks-xolda inversiya sonini bittaga oshirish
                    }
                }
            }
            if(nullPosition/4==0 && count%2==1) continues = false;
            //else if()
        }

        binding.click.setText(click1);
        //shuffle bo'lgan sonlarni bittalab qo'yib chiqamiz
        for(int i=0; i<list.size(); i++) {
            TextView t = findViewById(id+i);    //shu id-dagi TextView-ni t-ga o'zlashtirib olamiz
            if(list.get(i)==0) t.setText("");   //agar 0-kelsa yacheykani bo'sh qilib qo'y
            else t.setText(String.valueOf(list.get(i)));
        }
    }
    void click(TextView textView){
        if(textView.getText().equals("")) click++;
        binding.click.setText(String.valueOf(click));
    }
}