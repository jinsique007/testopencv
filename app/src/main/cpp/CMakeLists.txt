#
#cmake_minimum_required(VERSION 3.22.1)
#
#project("testopencv")
#
#
#add_library(${CMAKE_PROJECT_NAME} SHARED
#        # List C/C++ source files with relative paths to this CMakeLists.txt.
#        native-lib.cpp)
#
#
#target_link_libraries(${CMAKE_PROJECT_NAME}
#
#        android
#        log)

cmake_minimum_required(VERSION 3.22.1)

project("testopencv")

add_library( # Sets the name of the library.
        testopencv
        SHARED
        native-lib.cpp)

#opencv
set(OPENCV_LIBS_DIR ${CMAKE_SOURCE_DIR}/../opencv_include)
set(OPENCV_LIBS ${CMAKE_SOURCE_DIR}/../opencv_lib)

add_library(libopencv_java4
        SHARED
        IMPORTED )
set_target_properties(libopencv_java4
        PROPERTIES IMPORTED_LOCATION
        ${OPENCV_LIBS}/${ANDROID_ABI}/libopencv_java4.so )

#指定引入头文件目录
include_directories(${OPENCV_LIBS_DIR})

find_library( # Sets the name of the path variable.
        log-lib
        log)

target_link_libraries( # Specifies the target library.
        testopencv
        libopencv_java4
        jnigraphics #JNI层,添加bitmap支持
        ${log-lib})