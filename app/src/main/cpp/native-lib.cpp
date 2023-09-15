//#include <jni.h>
//#include <string>
//
//extern "C" JNIEXPORT jstring JNICALL
//Java_com_example_testopencv_MainActivity_stringFromJNI(
//        JNIEnv* env,
//        jobject /* this */) {
//    std::string hello = "Hello from C++";
//    return env->NewStringUTF(hello.c_str());
//}

#include <jni.h>
#include <string>
#include <android/bitmap.h>
#include <opencv2/opencv.hpp>
using namespace cv;
extern "C"
JNIEXPORT void JNICALL
Java_com_example_testopencv_MainActivity_opencv_1test(JNIEnv *env, jclass clazz,
                                                         jobject bitmap) {
    AndroidBitmapInfo info;
    void *pixels;

    CV_Assert(AndroidBitmap_getInfo(env, bitmap, &info) >= 0);
    //判断图片是位图格式有RGB_565 、RGBA_8888
    CV_Assert(info.format == ANDROID_BITMAP_FORMAT_RGBA_8888 ||
              info.format == ANDROID_BITMAP_FORMAT_RGB_565);
    CV_Assert(AndroidBitmap_lockPixels(env, bitmap, &pixels) >= 0);
    CV_Assert(pixels);

    //将bitmap转化为Mat类
    Mat image(info.height, info.width, CV_8UC4, pixels);
    // 高斯模糊
    GaussianBlur(image, image, Size(101, 101), 0);

}