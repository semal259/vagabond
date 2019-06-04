package com.sierra.vagabond.data.local;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.sierra.vagabond.data.entities.RecAreaFacilities;
import com.sierra.vagabond.data.entities.RecAreaMedia;
import com.sierra.vagabond.data.entities.RecreationalArea;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import io.reactivex.functions.Predicate;

@RunWith(AndroidJUnit4.class)
public class RecAreaDbTest {

    private RecAreaDao recAreaDao;
    private RecAreaDatabase recAreaDatabase;
    private static List<RecAreaMedia> testRecAreaMedia1 = Collections.singletonList(new RecAreaMedia("Sierra National Forest", 100, 700, "some-jpeg"));
    private static List<RecAreaFacilities> testRecAreaFacilities = Collections.singletonList(new RecAreaFacilities("2986", "Upper pines"));

    private static final RecreationalArea testRecreationalArea1 = new RecreationalArea("1074",
            "Sierra National Forest",
            "A description",
            "",
            "{}",
            "public_affairs@fs.fed.us",
            testRecAreaMedia1,
            testRecAreaFacilities);

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void createDB() {
        Context context = ApplicationProvider.getApplicationContext();
        recAreaDatabase = Room.inMemoryDatabaseBuilder(context, RecAreaDatabase.class).allowMainThreadQueries().build();
        recAreaDao = recAreaDatabase.recAreaDao();
    }

    @After
    public void closeDB() throws IOException {
        recAreaDatabase.close();
    }

    @Test
    public void testSaveAreas() throws Exception {
        recAreaDao.save(testRecreationalArea1)
                .test()
                .assertComplete();
    }

    @Test
    public void testGetArea() {
        recAreaDao.save(testRecreationalArea1).blockingAwait();
        recAreaDao.getArea(testRecreationalArea1.getRecAreaID())
                .test()
                .assertValue(new Predicate<RecreationalArea>() {
                    @Override
                    public boolean test(RecreationalArea recreationalArea) throws Exception {
                        return recreationalArea.getRecAreaID().equals(testRecreationalArea1.getRecAreaID()) &&
                                recreationalArea.getRecAreaName().equals(testRecreationalArea1.getRecAreaName());
                    }
                });
    }

}
