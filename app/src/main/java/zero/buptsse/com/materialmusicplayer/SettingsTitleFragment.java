package zero.buptsse.com.materialmusicplayer;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingsTitleFragment extends ListFragment
{
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, new String[]{"Title1", "Title2", "Title3"}));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}
