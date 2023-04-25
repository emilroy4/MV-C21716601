package c21716601;

import processing.core.PApplet;
import java.util.ArrayList;

public class nico {

    rockstar nico;

    public nico(rockstar nico) {
        this.nico = nico;
    }

    public float rotationAngle = 0.0f;
    public ParticleSystem particleSystem;

    public void setup() {
        particleSystem = new ParticleSystem();
    }

    public void render() {
        nico.noFill();
        nico.camera(0, 100, 200, 0, 0, 0, 1, 0, 0);
        nico.translate(0, 0, 0);
        nico.strokeWeight(4);

        float[] b = nico.getSmoothedBands();
        nico.stroke(0, 255, 0); // Green stroke color
        float size = b[2];

        // Apply rotation transformation
        nico.pushMatrix();
        nico.rotateZ(rotationAngle);
        nico.rect(-size / 2, -size / 2, size, size);
        nico.popMatrix();

        // Add particles to the system
        particleSystem.addParticles(size, nico.width / 2, nico.height / 2);

        // Update and draw the particle system
        particleSystem.update();
        particleSystem.display();

        // Increment rotation angle
        rotationAngle += 0.01f;
    }

    class Particle {
        float x, y, speedX, speedY, size, alpha;

        Particle(float x_, float y_, float speedX_, float speedY_, float size_, float alpha_) {
            x = x_;
            y = y_;
            speedX = speedX_;
            speedY = speedY_;
            size = size_;
            alpha = alpha_;
        }

        void update() {
            x += speedX;
            y += speedY;
            alpha -= 1;
        }

        void display() {
            nico.noStroke();
            nico.fill(0, 255, 0, alpha);
            nico.ellipse(x, y, size, size);
        }
    }

    class ParticleSystem {
        ArrayList<Particle> particles;
        int maxParticles = 1000;

        ParticleSystem() {
            particles = new ArrayList<Particle>();
        }

        void addParticles(float size, float x, float y) {
            final float PI = 3.14159265358979323846f;
            final float TWO_PI = 2 * PI;
            float speed = size / 20;
            for (int i = 0; i < size / 2; i++) {
                float angle = nico.random(TWO_PI);
                float speedX = speed * PApplet.cos(angle);
                float speedY = speed * PApplet.sin(angle);
                float particleSize = size / 10;
                particles.add(new Particle(x, y, speedX, speedY, particleSize, 255));
            }
        }

        void update() {
            for (int i = particles.size() - 1; i >= 0; i--) {
                Particle p = particles.get(i);
                p.update();
                if (p.alpha <= 0) {
                    particles.remove(i);
                }
            }
        }

        void display() {
            for (int i = 0; i < particles.size(); i++) {
                Particle p = particles.get(i);
                p.display();
            }
        }
    }

}