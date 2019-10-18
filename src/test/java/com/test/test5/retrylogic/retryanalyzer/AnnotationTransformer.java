package com.test.test5.retrylogic.retryanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import com.test.test5.retrylogic.retryanalyzer.RetryAnalyzer;
import com.test.test5.retrylogic.retryanalyzer.AnnotationTransformer;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
