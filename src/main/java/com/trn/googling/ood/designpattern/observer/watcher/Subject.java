package com.trn.googling.ood.designpattern.observer.watcher;

public interface Subject {

    void notifyObservers();
    void registerObserver(Watcher watcher);
    void removeObserver(Watcher watcher);
}
