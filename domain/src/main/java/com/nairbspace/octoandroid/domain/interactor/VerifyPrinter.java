package com.nairbspace.octoandroid.domain.interactor;

import com.nairbspace.octoandroid.domain.executor.PostExecutionThread;
import com.nairbspace.octoandroid.domain.executor.ThreadExecutor;
import com.nairbspace.octoandroid.domain.repository.PrinterRepository;

import javax.inject.Inject;

import rx.Observable;

public class VerifyPrinter extends UseCase {

    private final PrinterRepository mPrinterRepository;

    @Inject
    public VerifyPrinter(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                         PrinterRepository printerRepository) {
        super(threadExecutor, postExecutionThread);
        mPrinterRepository = printerRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mPrinterRepository.verifyPrinter();
    }
}
