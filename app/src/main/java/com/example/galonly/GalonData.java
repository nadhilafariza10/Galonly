package com.example.galonly;

import java.util.ArrayList;

public class GalonData {
    private static String[] clubName = {
            "Nabsyah Air Galon",
            "AHS AFK",
            "Cahaya GAlon",
            "Habibi Galon",
            "Depot Galon Segar Air Minum",
            "Toko BEST Solution Galon",
            "AHS AFK Tiga Bersaudara",
            "Depot Air Restu Ibu",
            "Depot Air Minum Adam Water",
            "Galsky"
    };

    private static String [] clubDetail = {
            "Alamat :Jl.Perintis Kemerdekaan",
            "Alamat : Jl. Moh.Hatta",
            "Alamat: Jl.Perintis Kemerdekaan",
            "Alamat : Jl.Perintis Kemerdekaan",
            "Alamat : Jl.Perintis Kemerdekaan",
            "Alamat : Jl.Perintis Kemerdekaan",
            "Alamat : Jl. Moh.Hatta",
            "Alamat : Jl. Moh.Hatta",
            "Alamat : Jl. Moh.Hatta" ,
            "Alamat :Jl. Moh.Hatta"

    };

    private static int[] clubPhoto = {
            R.drawable.galon1,
            R.drawable.galon2,
            R.drawable.galon3,
            R.drawable.galon4,
            R.drawable.galon3,
            R.drawable.galon1,
            R.drawable.galon2,
            R.drawable.galon4,
            R.drawable.galon3,
            R.drawable.galon1
    };

    private static String [] clubbukaTutup = {
            "Buka-Tutup : 08.00 -22.00 WIB",
            "Buka-Tutup : 08.00 -22.00 WIB",
            "Buka-Tutup : 08.00 -22.00 WIB",
            "Buka-Tutup : 08.00 -22.00 WIB"
    };

    private static String [] clubharga = {
            "Harga : Rp.5000",
            "Harga : Rp.5000",
            "Harga : Rp.5000",
            "Harga : Rp.5000",
            "Harga : Rp.5000"

    };

    static ArrayList<Galon> getListData(){
        ArrayList<Galon> list = new ArrayList<>();
        for (int position = 0;position <clubName.length;position++){
            Galon galon = new Galon();
            galon.setName(clubName[position]);
            galon.setDetail(clubDetail[position]);
            galon.setPhoto(clubPhoto[position]);
            list.add(galon);
        }
        return list;
    }
}
