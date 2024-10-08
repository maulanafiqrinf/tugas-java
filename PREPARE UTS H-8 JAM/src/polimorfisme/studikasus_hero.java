/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme;

/**
 *
 * @author Lenovo
 */
public class studikasus_hero {

        String skill;
        // ngatur skill

        public void setSkill() {
            System.out.println("hero ini punya skill");
        }

        public static void main(String[] args) {

            Usman77 us = new Usman77();
            Umar99 um = new Umar99();

            us.setSkill();
            um.setSkill();

        }
    }

    class Usman77 extends studikasus_hero {

        @Override
        public void setSkill() {
            System.out.println("membunuh dengan tatapan");
        }

    }

    class Umar99 extends studikasus_hero {

        @Override
        public void setSkill() {
            System.out.println("membunuh dengan senyuman");
        }
    }

