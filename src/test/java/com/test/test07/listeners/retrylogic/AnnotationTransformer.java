package com.test.test07.listeners.retrylogic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.test.test07.listeners.retrylogic.AnnotationTransformer;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
