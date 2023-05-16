package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import com.praepositi.fossilsorigins.entity.VelociraptorEntity;
import com.praepositi.fossilsorigins.entity.TyrannosaurausEntity;
import com.praepositi.fossilsorigins.entity.SpinosaurusEntity;
import com.praepositi.fossilsorigins.entity.MosasaurusEntity;
import com.praepositi.fossilsorigins.entity.DilophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CryolophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CompsognathusEntity;
import com.praepositi.fossilsorigins.entity.CarnotaurusEntity;

public class FeedingCarnivoresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TyrannosaurausEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof SpinosaurusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof CarnotaurusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof MosasaurusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof CompsognathusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof VelociraptorEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof DilophosaurusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		} else if (entity instanceof CryolophosaurusEntity) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("Hunger", entity) + 2500));
			}
		}
	}
}
