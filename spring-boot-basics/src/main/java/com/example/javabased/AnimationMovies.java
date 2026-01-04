package com.example.javabased;

import java.util.List;


public class AnimationMovies implements IMovie{

	@Override
	public List<String> showMovies() {
		return List.of("Tangled","Soul");
	}

}
