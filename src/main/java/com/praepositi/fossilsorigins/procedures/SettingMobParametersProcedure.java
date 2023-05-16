package com.praepositi.fossilsorigins.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import com.praepositi.fossilsorigins.entity.TyrannosaurausEntity;
import com.praepositi.fossilsorigins.entity.TriceratopsEntity;
import com.praepositi.fossilsorigins.entity.StegosaurusEntity;
import com.praepositi.fossilsorigins.entity.SpinosaurusEntity;
import com.praepositi.fossilsorigins.entity.PteranodonEntity;
import com.praepositi.fossilsorigins.entity.PlesiosuarusEntity;
import com.praepositi.fossilsorigins.entity.MosasaurusEntity;
import com.praepositi.fossilsorigins.entity.GalimimusEntity;
import com.praepositi.fossilsorigins.entity.DryosaurusEntity;
import com.praepositi.fossilsorigins.entity.DimetrodonEntity;
import com.praepositi.fossilsorigins.entity.DilophosaurusEntity;
import com.praepositi.fossilsorigins.entity.CarnotaurusEntity;
import com.praepositi.fossilsorigins.entity.BrachiosaurusEntity;
import com.praepositi.fossilsorigins.entity.AnkylosaurusEntity;

public class SettingMobParametersProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double ModificationChance = 0;
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("BabySize", entity) == 0) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Hunger");
				if (_so == null)
					_so = _sc.addObjective("Hunger", ObjectiveCriteria.DUMMY, Component.literal("Hunger"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(10000);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Tranqvalue");
				if (_so == null)
					_so = _sc.addObjective("Tranqvalue", ObjectiveCriteria.DUMMY, Component.literal("Tranqvalue"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Gender");
				if (_so == null)
					_so = _sc.addObjective("Gender", ObjectiveCriteria.DUMMY, Component.literal("Gender"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) Math.random());
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("BabySize");
				if (_so == null)
					_so = _sc.addObjective("BabySize", ObjectiveCriteria.DUMMY, Component.literal("BabySize"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) Mth.nextDouble(RandomSource.create(), 1, 3));
			}
		}
		CareValueCreaturesProcedure.execute(entity);
		if (entity instanceof AnkylosaurusEntity) {
			AnkySexualDiffrencesProcedure.execute(entity);
		} else if (entity instanceof MosasaurusEntity) {
			MosasaurusSexualDimorphismProcedure.execute(entity);
		} else if (entity instanceof TyrannosaurausEntity) {
			TrexSexualDiffrenceProcedure.execute(entity);
		} else if (entity instanceof StegosaurusEntity) {
			StegoSeuxaldimorphisimProcedure.execute(entity);
		} else if (entity instanceof SpinosaurusEntity) {
			SpinosexualdimorphisimProcedure.execute(entity);
		} else if (entity instanceof PteranodonEntity) {
			PteranodonSexualDimorphodonProcedure.execute(entity);
		} else if (entity instanceof GalimimusEntity) {
			GalimimusSexualDimorphisimProcedure.execute(entity);
		} else if (entity instanceof PlesiosuarusEntity) {
			PlesioSexualDimorphosimProcedure.execute(entity);
		} else if (entity instanceof BrachiosaurusEntity) {
			BrachiosaurusSexualDimorphosimProcedure.execute(entity);
		} else if (entity instanceof TriceratopsEntity) {
			TrexSexualDiffrenceProcedure.execute(entity);
		} else if (entity instanceof DryosaurusEntity) {
			DryosaurusSexualDimorphisimProcedure.execute(entity);
		} else if (entity instanceof CarnotaurusEntity) {
			CarnoSexualDimorphisimProcedure.execute(entity);
		} else if (entity instanceof DimetrodonEntity) {
			DemitrodonSexualDimorphisimProcedure.execute(entity);
		} else if (entity instanceof DilophosaurusEntity) {
			DilophosaurusSexualDimorphisimProcedure.execute(entity);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.isBaby() : false) {
			return new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("BabySize", entity) * 0.1;
		}
		return new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("BabySize", entity) * 0.548;
	}
}
