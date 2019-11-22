package com.example.munazamfyp.DataModels;

public class Example_item2
{
    private String ImageResource;
    private String mText1;
    private String mText2;
    private String Edittext1;





    public Example_item2(String imageResource, String edittext1, String mText1, String mText2) {

        ImageResource = imageResource;
        Edittext1 = edittext1;
        this.mText1 =mText1;
        this.mText2=mText2;

    }


    public String getImageResource() {
        return ImageResource;
    }


    public String getEdittext1() {
        return Edittext1;
    }

    public String getEdittext2() {
        return mText1;
    }


    public String getEdittext3() {
        return mText2;
    }



}
