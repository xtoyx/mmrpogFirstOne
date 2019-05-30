package com.mygdx.game;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public class TiledObjectlayer {
    public static void parseTiledObjectLayer(World world, MapObjects objects){
        for(MapObject object : objects){
            Shape shape;
            if(object instanceof PolylineMapObject){
                shape= createPolyLine((PolylineMapObject) object);
                System.out.println("worked2");
            } else{
                continue;
            }

            Body body;
            BodyDef bdef=new BodyDef();
            bdef.type=BodyDef.BodyType.StaticBody;
            body=world.createBody(bdef);
            body.createFixture(shape,1.0f).setUserData("ground");
        }
    }
    public static void parseTiledObjectLayer1(World world, MapObjects objects){
        for(MapObject object : objects){
            Shape shape;
            if(object instanceof PolylineMapObject){
                shape= createPolyLine1((PolylineMapObject) object);
                System.out.println("worked2");
            } else{
                continue;
            }

            Body body;
            BodyDef bdef=new BodyDef();
            bdef.type=BodyDef.BodyType.StaticBody;
            body=world.createBody(bdef);
            body.createFixture(shape,1.0f).setUserData("ground");
        }
    }

    private static ChainShape createPolyLine(PolylineMapObject polyline) {
        float[] vertices =polyline.getPolyline().getTransformedVertices();
        Vector2[] worldVertices =new Vector2[vertices.length/2];
         for(int i=0;i<worldVertices.length;i++){
             worldVertices[i]=new Vector2((vertices[i*2]/Playscreen.PIXEL_PER_METER*4)*8,(vertices[i*2+1]/Playscreen.PIXEL_PER_METER*4)*Playscreen.PIXEL_PER_METER/4);
         }
         ChainShape Cs=new ChainShape();
         Cs.createChain(worldVertices);
        return Cs;

    }
    private static ChainShape createPolyLine1(PolylineMapObject polyline) {
        float[] vertices =polyline.getPolyline().getTransformedVertices();
        Vector2[] worldVertices =new Vector2[vertices.length/2];
        for(int i=0;i<worldVertices.length;i++){
            worldVertices[i]=new Vector2((vertices[i*2]/Playscreen.PIXEL_PER_METER*4)*16,(vertices[i*2+1]/Playscreen.PIXEL_PER_METER*4)*Playscreen.PIXEL_PER_METER/4*2);
        }
        ChainShape Cs=new ChainShape();
        Cs.createChain(worldVertices);
        return Cs;

    }
}