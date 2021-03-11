package com.music.backend.rest.model;

import com.music.backend.model.entity.Note;
import com.music.backend.model.instruments.DrumMidi;
import com.music.backend.service.DrumMidiService;
import com.music.backend.util.Tone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drumMidi")
public class DrumMidiController {

    private final DrumMidiService service;

    public DrumMidiController(@Autowired DrumMidiService service) {
        this.service = service;
    }

    @GetMapping("/raw")
    public DrumMidi getRaw() {
        return service.getRawDrumMidi();
    }

    @GetMapping("/tone")
    public DrumMidi getTone(@RequestParam String note, @RequestParam String tone) {
        return service.getToneDrumMidi(new Note(note), Tone.valueOf(tone.toUpperCase()));
    }

    @GetMapping("/chord")
    public DrumMidi getChord(@RequestParam String note, @RequestParam String tone) {
        return service.getChordDrumMidi(new Note(note), Tone.valueOf(tone.toUpperCase()));
    }

    @GetMapping("/interval")
    public DrumMidi getInterval(@RequestParam int startKey,
                              @RequestParam int... interval) {
        return service.getIntervalDrumMidi(startKey, interval);
    }
}
