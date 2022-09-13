package renderEngine;

import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;

public class DisplayManager {
	
	private static int WIDTH = 1280;
	private static int HEIGHT = 720;
	public static long window;
	
	public static void createWindow() {
		
		if(!glfwInit()) 
			throw new IllegalStateException("Failed to initialize GLFW");

		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		glfwWindowHint(GLFW_VERSION_MAJOR, 4);
		glfwWindowHint(GLFW_VERSION_MINOR, 6);
		window = glfwCreateWindow(WIDTH, HEIGHT, "My LWJGL Game", 0, 0);
		if(window == 0)
			throw new RuntimeException("Failed to create the GLFW window!");
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		glfwSwapInterval(1);
		glfwShowWindow(window);
		System.out.println("Window created!");
		
	}
	
	public static void updateWindow() {
		
		while(!glfwWindowShouldClose(window)) {
			
			glfwSwapBuffers(window);
			glfwPollEvents();
			
		}
		
	}
	
	public static void closeDisplay() {
		
		glfwDestroyWindow(window);
		
	}
	
}
