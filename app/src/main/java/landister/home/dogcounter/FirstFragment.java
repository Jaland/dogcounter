package landister.home.dogcounter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int currentCount = sharedPref.getInt(getString(R.string.count), 0);
        ((TextView)getActivity().findViewById(R.id.FirstFragment).findViewById(R.id.text_counter)).setText(currentCount);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                int newCount = sharedPref.getInt(getString(R.string.count), 0) + 1;
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(getString(R.string.count), newCount);
                editor.apply();
                ((TextView)view.findViewById(R.id.text_counter)).setText(newCount);
            }
        });
    }
}