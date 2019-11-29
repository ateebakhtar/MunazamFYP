package com.example.munazamfyp.DataModels;

public class WorkloadViewModel
{


    private String ImageResource1;
    private String ImageResource2;
    private String ImageResource3;
    private String ImageResource4;
    private String mText1;
    private String mText2;
    private String Edittext1;
    private int a;

    public WorkloadViewModel(String imageResource1, String imageResource2, String imageResource3, String imageResource4, String edittext1) {
        ImageResource1 = imageResource1;
        ImageResource2 = imageResource2;
        ImageResource3 = imageResource3;
        ImageResource4 = imageResource4;
        Edittext1 = edittext1;


    }



    public String getImageResource1() {
        return ImageResource1;

    }
    public String getImageResource2() {
        return ImageResource2;

    }
    public String getImageResource3() {
        return ImageResource3;

    }
    public String getImageResource4() {
        return ImageResource4;


    }

    public String getEdittext1() {
        return Edittext1;}
}
