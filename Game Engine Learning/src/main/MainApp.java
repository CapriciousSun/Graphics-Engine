package main;

import static org.lwjgl.glfw.GLFW.*;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DisplayManager.createWindow();
		Loader loader = new Loader();
		Renderer renderer =  new Renderer();
		
		// OpenGL expects vertices to be defined counter clockwise by default
		float[] vertices = {
				// Left bottom triangle
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				// Right top triangle
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f, 0.5f, 0f
		};
		
		RawModel model = loader.loadToVAO(vertices);
		
		while(!glfwWindowShouldClose(DisplayManager.window)) {
			
			renderer.prepare();
			renderer.render(model);
			DisplayManager.updateWindow();
			
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
		
	}
	
}
