package ru.mirea.dyachenkov.mireaproject.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.dyachenkov.mireaproject.R;
import ru.mirea.dyachenkov.mireaproject.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        webView = (WebView) view.findViewById(R.id.text_gallery);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://ya.ru/");
        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}