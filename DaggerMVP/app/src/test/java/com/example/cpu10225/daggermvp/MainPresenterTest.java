package com.example.cpu10225.daggermvp;

import com.example.cpu10225.daggermvp.data.DataManager;
import com.example.cpu10225.daggermvp.data.network.ApiHelper;
import com.example.cpu10225.daggermvp.data.network.model.Post;
import com.example.cpu10225.daggermvp.ui.main.MainMvpPresenter;
import com.example.cpu10225.daggermvp.ui.main.MainMvpView;
import com.example.cpu10225.daggermvp.ui.main.MainPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by cpu10225 on 22/12/2017.
 */

public class MainPresenterTest {

    @Mock
    private ApiHelper apiHelper;

    @Mock
    private MainMvpView mainMvpView;

    @Mock
    private DataManager dataManager;

    @Mock
    MainPresenter<MainMvpView> presenter = new MainPresenter<>(dataManager);

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchValidPostShouldLoadIntoView() {
//        Post post1 = new Post(1, 1, "1", "1");
//        Post post2 = new Post(2, 2, "2", "2");
//        Post post3 = new Post(3, 3, "3", "3");
//        List<Post> postList = new ArrayList<>();
//        postList.add(post1);
//        postList.add(post2);
//        postList.add(post3);

        when(apiHelper.getPostList())
                .thenReturn(Observable.<List<Post>>empty());

        presenter.loadPost();

//        InOrder inOrder = Mockito.inOrder(mainMvpView);
//        inOrder.verify(mainMvpView, times(1)).showComplete();
    }
}