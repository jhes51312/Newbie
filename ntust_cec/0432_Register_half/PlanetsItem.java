package f.com.mple.my0423welll;

public class PlanetsItem {

    private int mImgId;
    private String mName;
    private String mPhone;
    private String mAge;
    private String mAddress;

    public PlanetsItem(int ImgId, String name , String phone , String age , String address){
        mImgId = ImgId;
        mName = name;
        mPhone = phone;
        mAge = age;
        mAddress = address;
    }

    public int getImgId(){
        return mImgId;
    }
    public String getName(){
        return mName;
    }
    public String getPhone(){
        return mPhone;
    }
    public String getAge(){
        return mAge;
    }
    public String getAddress(){
        return mAddress;
    }
}