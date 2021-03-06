package edu.iastate.graysonc.fastfood.recyclerClasses;

import android.os.Parcel;
import android.os.Parcelable;

import edu.iastate.graysonc.fastfood.database.entities.Food;

public class recycler_card implements Parcelable {
    private String name;
    private String mLine2;
    private int id;
    private boolean favored;
    private int foodId;
    private Food foodObj;


    //Food(@NonNull int id, String name, int proteinTotal, int carbTotal, int fatTotal, int calorieTotal, int location)


    /**
     * @param Name      Name of card
     * @param Misc_Data Secondary data On Card
     */
    public recycler_card(int foodId, String Name, String Misc_Data) {
        this(foodId, Name, Misc_Data, true);
    }

    /**
     * @param Name      Name of card
     * @param Misc_Data Secondary data On Card
     * @param fav       Indicates if card is favored or not
     */
    public recycler_card(int foodId, String Name, String Misc_Data, boolean fav) {
        this.foodId = foodId;
        name = Name;
        mLine2 = Misc_Data;
        favored = fav;
    }

    /**
     * @param Name      Name of card
     * @param Misc_Data Secondary data On Card
     * @param fav       Indicates if card is favored or not
     * @param id        Database UID of the card
     */
    public recycler_card(int foodId, String Name, String Misc_Data, boolean fav, int id) {
        this.foodId = foodId;
        name = Name;
        mLine2 = Misc_Data;
        favored = fav;
        this.id = id;
    }

    public recycler_card(Food food) {
        //Food(@NonNull int id, String name, int proteinTotal, int carbTotal, int fatTotal, int calorieTotal, int location)
        this.name = food.getName();
        mLine2 = "";
        id = food.getId();
        foodId = food.getId();
        foodObj = food;

    }

    protected recycler_card(Parcel in) {
        this.foodId = in.readInt();
        name = in.readString();
        mLine2 = in.readString();
        favored = in.readByte() != 0;
        id = in.readInt();
    }

    public static final Creator<recycler_card> CREATOR = new Creator<recycler_card>() {

        @Override
        public recycler_card createFromParcel(Parcel in) {
            return new recycler_card(in);
        }

        @Override
        public recycler_card[] newArray(int size) {
            return new recycler_card[size];
        }
    };

    public String getFood() {
        return name;
    }

    public String getData() {
        return mLine2;
    }

    public boolean isFavored() {
        return favored;
    }

    public void setFavored(boolean val) {favored = val;}

    public void setID(int val) {id = val;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(mLine2);
        dest.writeValue(favored);
        dest.writeInt(id);
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public Food getFoodObj() {
        return foodObj;
    }

    public void setmLine2(String text) {mLine2 = text; }
}
