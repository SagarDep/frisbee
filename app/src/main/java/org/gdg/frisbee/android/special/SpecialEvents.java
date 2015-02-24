package org.gdg.frisbee.android.special;

import android.os.Parcel;
import android.os.Parcelable;

import org.gdg.frisbee.android.R;
import org.joda.time.DateTime;

public class SpecialEvents implements Parcelable {
    private static final long DATE_2015_06_01_GMT_IN_MILLIS = 1433116800000L;
    private static final long DATE_2015_04_01_GMT_IN_MILLIS = 1427846400000L;

    private String mTag;
    private int mDrawerIconResId;
    private int mTitleResId;
    private int mDescriptionResId;
    private int mLogoResId;
    private long mSartDateInMillis;
    private long mEndDateInMillis;


    public SpecialEvents(String tag, int drawerIconResId, int titleResId, int descriptionResId, int logoResId, long endDateInMillis) {
        mTag = tag;
        mDrawerIconResId = drawerIconResId;
        mTitleResId = titleResId;
        mDescriptionResId = descriptionResId;
        mLogoResId = logoResId;
        mSartDateInMillis = DateTime.now().getMillis();
        mEndDateInMillis = endDateInMillis;
    }

    public static SpecialEvents getCurrent() {
        return new SpecialEvents("wtm", R.drawable.drw_ic_wtm, R.string.wtm, R.string.wtm_description,
                R.drawable.ic_wtm, DATE_2015_04_01_GMT_IN_MILLIS);
    }

    public String getTag() {
        return mTag;
    }

    public int getDrawerIconResId() {
        return mDrawerIconResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getDescriptionResId() {
        return mDescriptionResId;
    }

    public int getLogoResId() {
        return mLogoResId;
    }

    public long getEndDateInMillis() {
        return mEndDateInMillis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTag);
        dest.writeInt(this.mDrawerIconResId);
        dest.writeInt(this.mTitleResId);
        dest.writeInt(this.mDescriptionResId);
        dest.writeInt(this.mLogoResId);
        dest.writeLong(this.mSartDateInMillis);
        dest.writeLong(this.mEndDateInMillis);
    }

    private SpecialEvents(Parcel in) {
        this.mTag = in.readString();
        this.mDrawerIconResId = in.readInt();
        this.mTitleResId = in.readInt();
        this.mDescriptionResId = in.readInt();
        this.mLogoResId = in.readInt();
        this.mSartDateInMillis = in.readLong();
        this.mEndDateInMillis = in.readLong();
    }

    public static final Parcelable.Creator<SpecialEvents> CREATOR = new Parcelable.Creator<SpecialEvents>() {
        public SpecialEvents createFromParcel(Parcel source) {
            return new SpecialEvents(source);
        }

        public SpecialEvents[] newArray(int size) {
            return new SpecialEvents[size];
        }
    };
}
