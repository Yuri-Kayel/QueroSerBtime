package yuri.kayel.dojopuzzles.interactor;//package yuri.kayel.bookofeulogies.interactor;
//
///**
// * Created by yurik on 18/01/2018.
// */
//
//public class SampleInteractor
//{
//    public void saveProducts(final ProductDAO.OnDisposeDao onDisposeDao,
//                             final CriticalFailureListener criticalFailureListener,
//                             final String userToken) {
//        apiObject.someMethod(etc)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<AllProduct>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.getCause();
//
//                        ProductDAO productDAO = new ProductDAO(context);
//
//                        if (productDAO.getAllProducts() != null) {
//                            if (productDAO.getAllProducts().size() > 0) {
//                                criticalFailureListener.mitigateCriticalFailure();
//                            }
//                            else {
//                                criticalFailureListener.onCriticalProductLoadFailure();
//                            }
//                        }
//                        else {
//                            criticalFailureListener.onCriticalProductLoadFailure();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(AllProduct responseBody) {
//                        ProductDAO productDAO = new ProductDAO(context);
//                        productDAO.saveAllProducts(responseBody.getProducts(), onDisposeDao);
//                    }
//                });
//    }
//
//    public void putUpdatedTime(String token, final onUpdatedTimeListener onUpdatedTimeListener) {
//        apiObject.someMethod(etc)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<JSONObject>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(JSONObject responseBody) {
//                        onUpdatedTimeListener.onUpdatedTime();
//                    }
//                });
//    }
//
//    public void getProductUpdate(final ProductDAO.OnDisposeDao onDisposeDao,
//                                 final CriticalFailureListener listener,
//                                 final String userToken) {
//        apiObject.someMethod(etc)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<ProductUpdate>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.getCause();
//
//                        ProductDAO productDAO = new ProductDAO(context);
//
//                        if (productDAO.getAllProducts() != null) {
//                            if (productDAO.getAllProducts().size() > 0) {
//                                listener.mitigateCriticalFailure();
//                            }
//                            else {
//                                listener.onCriticalProductLoadFailure();
//                            }
//                        }
//                        else {
//                            listener.onCriticalProductLoadFailure();
//                        }
//                    }
//
//                    @Override
//                    public void onNext(ProductUpdate responseBody) {
//                        ProductDAO productDAO = new ProductDAO(context);
//                        productDAO.saveAllProducts(responseBody.getProducts(), onDisposeDao);
//                    }
//                });
//    }
//
//    public void getAbout(int language, final OnAboutListener listener) {
//        apiObject.someMethod(etc)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<AboutResponse>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        listener.onAboutError(AdaliveApplication.getInstance().getString(R.string.ERRO_ABOUT));
//                    }
//
//                    @Override
//                    public void onNext(AboutResponse aboutResponse) {
//                        listener.onAboutSuccess(aboutResponse);
//                    }
//
//                });
//    }
//}
