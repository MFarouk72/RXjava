package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;


public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MAIN_ACTIVITY" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        //this code for cold observable
        //intervalRange take information for the range
        Observable<Long> cold = Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS) ;
        cold.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        sleep(3000);
        cold.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));

        */
        /*
        //this code for convert cold observable to hot observable(connectable observable)
        //intervalRange take information for the range
        ConnectableObservable<Long> cold = ConnectableObservable.intervalRange(0,5,0,1, TimeUnit.SECONDS).publish() ;
        cold.connect();
        cold.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        sleep(3000);
        cold.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));
        */
        /*
        //Hot Observable (publishSubject) listen from the first time he enter
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onNext("D");
        subject.onNext("E");
        subject.onNext("F");
        subject.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));
        subject.onNext("G");
        subject.onNext("H");
        subject.onNext("K");
        subject.onNext("L");
        subject.onNext("M");
        subject.onNext("N");

         */
        /*
        //Hot Observable (behaviorSubject) listen to the last information and continue
        BehaviorSubject<String> subject = BehaviorSubject.create();
        subject.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onNext("D");
        subject.onNext("E");
        subject.onNext("F");
        subject.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));
        subject.onNext("G");
        subject.onNext("H");
        subject.onNext("K");
        subject.onNext("L");
        subject.onNext("M");
        subject.onNext("N");

         */
        /*
        //Hot Observable (ReplaySubject) repeat from the first again
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onNext("D");
        subject.onNext("E");
        subject.onNext("F");
        subject.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));
        subject.onNext("G");
        subject.onNext("H");
        subject.onNext("K");
        subject.onNext("L");
        subject.onNext("M");
        subject.onNext("N");

         */
        //Hot Observable (AsyncSubject) listen to the last thing
        AsyncSubject<String> subject = AsyncSubject.create();
        subject.subscribe(i-> Log.d(TAG,"onCreate : student1: "+i));
        subject.onNext("A");
        subject.onNext("B");
        subject.onNext("C");
        subject.onNext("D");
        subject.onNext("E");
        subject.onNext("F");
        subject.subscribe(i-> Log.d(TAG,"onCreate : student2: "+i));
        subject.onNext("G");
        subject.onNext("H");
        subject.onNext("K");
        subject.onNext("L");
        subject.onNext("M");
        subject.onNext("N");
        subject.onComplete();


    }
    //this function to make the thread wait the number of seconds we want
    public void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}