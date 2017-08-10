package src;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import src.ExpandableListViewWithCollapse;

public class SecondLevelExpandableListView extends ExpandableListViewWithCollapse
{

        public SecondLevelExpandableListView(Context context) {
			super(context);
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//            //999999 is a size in pixels. ExpandableListView requires a maximum height in order to do measurement calculations.
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(999999, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
}