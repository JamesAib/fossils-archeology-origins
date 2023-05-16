package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.Entity;

import com.praepositi.fossilsorigins.entity.MosasaurusEntity;

public class MosasaurusSexualDimorphismProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("Gender", entity) == 1) {
			if (entity instanceof MosasaurusEntity animatable)
				animatable.setTexture("mosa_blue");
		} else if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("Gender", entity) == 2) {
			if (entity instanceof MosasaurusEntity animatable)
				animatable.setTexture("mosasuarus");
		} else {
			if (entity instanceof MosasaurusEntity animatable)
				animatable.setTexture("mosa_brown");
		}
	}
}
