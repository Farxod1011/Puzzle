package uz.farxod.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import uz.farxod.puzzle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Button emptyButton; //bo'sh knopka

    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0); //inversiyani xisoblash uchun raqamli massiv

    private int x = 3; //tag - ning koordinatasi
    private int y = 3; //tag - ning koordinatasi. 33-tag da bo'sh joy bor
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shuffle.setOnClickListener(z->{
            shuffle();
        });

        for(int i=0; i<binding.layoutContainer.getChildCount(); i++){ //get Child Count - получать количество детей
            if(list.get(i)==0) ((Button) binding.layoutContainer.getChildAt(i)).setText("");    //to'ldirishda 0-uchrasa uni bo'sh qilamiz
            else ((Button) binding.layoutContainer.getChildAt(i)).setText(String.valueOf(list.get(i)));
        }


    }

    public void onClick(View view){
        int counter = 1;

        Button clicked = (Button) view;         //bosilgan knopka
        String tag = view.getTag().toString();  //bosilgan knopkani tag-ini ovolamiz
        int cordinatX = tag.charAt(0) - '0';    //olingan tag ni 0-chi indexini o'zgaruvchiga saqlaymiz
        int cordinatY = tag.charAt(1) - '0';    //olingan tag ni 1-chi indexini o'zgaruvchiga saqlaymiz

    //(cordinatX + cordinatY)-bosilgan knopka kordinatalari, (x+y)-bo'sh, yozuvsiz knopka kordinatasi
        if(Math.abs(cordinatX + cordinatY - (x+y)) == 1 && Math.abs(cordinatX - x) != 2 && Math.abs(cordinatY - y) != 2){
            String text = clicked.getText().toString(); //bosilgan knopka tekstini olib saqlaymiz
            clicked.setText("");            //bosilgan knopka tekstini "" bo'sh qilib qo'yamiz
        //clicked.setVisibility(View.INVISIBLE);
            emptyButton.setText(text);      //bo'sh knopkaga bosilgan knopka tekstini o'zlashtiramiz
            emptyButton = clicked;          //bosilgan knopkani bo'shiga o'zlashtiramiz
            //emptyButton.setVisibility(View.VISIBLE);
            x = cordinatX;      //bo'sh joy kordinatasini bosilgan knopka kordinatasi bilan almasjtiramiz
            y = cordinatY;
        }
        for(int i=0; i<16; i++){
            Button ch = ((Button) binding.layoutContainer.getChildAt(i));       //knopkant birin-ketinlikda topib olamiz
        //agar ch-bosilgan knopka bo'sh bo'lsa yoki ch-ning teksti counter-ga teng bo'lmasa sikl to'xtasin
            if(ch.getText().toString().isEmpty() || (Integer.parseInt(ch.getText().toString()) != counter)){
                break;}
            else counter++;
            //agar counter 16-gacha borsa tost chiqsin
            if(counter==16) Toast.makeText(this, "URA.. siz yutdingiz", Toast.LENGTH_SHORT).show();
        }
    }
    void shuffle(){
        boolean n = true;       //shart bajarilganidan so'ng while to'xtashi uchun
        int invertions = 0;     //inversiya soni

        while (n) {
            Collections.shuffle(list);
            for(int i=0; i<list.size(); i++){
                if(list.get(i)==0){         //agar bo'sh joy kelib qolsa
                    invertions += i/4 + 1;  //bo'sh joy pozirsiyasini bilish va uni inversiya soniga qo'shish
                    continue;               //davom etish
                }
                for(int j=i+1; j<list.size(); j++){ //ichki sikl
                    if(list.get(i) > list.get(j))   //akar birinchi sondan kiyingisi katta bo'lsa ++ bo'lsin
                        invertions++;
                }
            }
            if(invertions% 2 == 0){     //agar inversiya soni juft bo'lsa while sikli to'xtasin
                n = false;
            }
        }
    //list ni ektanga terib chiqamiz
        for(int i=0; i<binding.layoutContainer.getChildCount(); i++){ //get Child Count - получать количество детей
            if(list.get(i)==0){
                String tag = binding.layoutContainer.getChildAt(i).getTag().toString();  //bo'sh knopkani tag-ini ovolamiz
                x = tag.charAt(0) - '0';    //olingan tag ni 0-chi indexini o'zgaruvchiga saqlaymiz
                y = tag.charAt(1) - '0';    //olingan tag ni 1-chi indexini o'zgaruvchiga saqlaymiz

                emptyButton = (Button) binding.layoutContainer.getChildAt(i); //i-qayerda bo'lsa bo'sh knopkaxam shu yerda bo'ladi
                //emptyButton.setVisibility(View.INVISIBLE); //knopkani yashirish
                ((Button) binding.layoutContainer.getChildAt(i)).setText("");    //to'ldirishda 0-uchrasa uni bo'sh qilamiz
            }
            else ((Button) binding.layoutContainer.getChildAt(i)).setText(String.valueOf(list.get(i)));
        }

    }
}