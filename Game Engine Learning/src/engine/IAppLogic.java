package engine;

import engine.graph.Render;
import engine.scene.Scene;

public interface IAppLogic {

	// Cleans up resources
	void cleanup();
	
	// Initializes game assets
	void init(Window window, Scene scene, Render render);
	
	// User inputs
	void input(Window window, Scene scene, long diffTimeMillis);
	
	// Updates game state
	void update(Window window, Scene scene, long diffTimeMillis);
	
}
